package br.com.planilha.gastos.planilha.dto;

import br.com.planilha.gastos.common.validacoes.PadraoString;
import br.com.planilha.gastos.common.validacoes.PadroesValidacoesEnum;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanilhaDto extends RepresentationModel<PlanilhaDto> {
  private long id;
  @PadraoString(pattern = PadroesValidacoesEnum.MM_YYYY)
  private String referencia;
}
