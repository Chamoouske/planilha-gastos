package br.com.planilha.gastos.common.validacoes;

import lombok.Getter;

@Getter
public enum PadroesValidacoesEnum {
  MM_YYYY("^(0[1-9]|1[0-2])-(\\\\d{4})$");
  private final String regex;

  PadroesValidacoesEnum(String regex) {
    this.regex = regex;
  }

}
