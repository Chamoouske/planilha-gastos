package br.com.planilha.gastos.planilha.dto;

import br.com.planilha.gastos.common.validacoes.PadraoString;
import br.com.planilha.gastos.common.validacoes.PadroesValidacoesEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FiltroPlanilhaDto {
  private Long id;
  @PadraoString(pattern = PadroesValidacoesEnum.MM_YYYY, message = "O campo referencia deve ser no padrão MM-YYYY")
  private String referencia;
}
