package br.com.planilha.gastos.common.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class HandlerErros {
  @ExceptionHandler(Exception.class)
  public ResponseEntity.BodyBuilder handler(Exception ex) {
    log.error(ex.getMessage(), ex);

    return ResponseEntity.internalServerError();
  }
}
