import { ChildProcessWithoutNullStreams } from 'child_process';
import { app, BrowserWindow } from 'electron';
import * as isDev from 'electron-is-dev';
import * as path from 'path';
import * as url from 'url';

const __dirname = import.meta.dirname;

let mainWindow: BrowserWindow | null = null;
let child: ChildProcessWithoutNullStreams;

function createWindow() {
  mainWindow = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      nodeIntegration: true,
    },
  });

  mainWindow.loadURL(defineUrl());

  mainWindow.on('closed', () => (mainWindow = null));
  if (isDev) {
    mainWindow.webContents.openDevTools();
  } else {
    const jarPath = path.join(
      __dirname,
      '..',
      '..',
      'backend',
      'target',
      'backend-0.0.1-SNAPSHOT.jar'
    );
    child = require('child_process').spawn('java', ['-jar', jarPath, '']);
  }
}

app.on('ready', createWindow);

app.on('window-all-closed', function () {
  if (child) require('tree-kill')(child.pid);
  if (process.platform !== 'darwin') app.quit();
});

app.on('activate', function () {
  if (mainWindow === null) createWindow();
});

function defineUrl() {
  return isDev
    ? 'http://localhost:4200/index.html'
    : url.format({
        pathname: path.join(__dirname, '../angular/browser/index.html'),
        protocol: 'file:',
        slashes: true,
      });
}
