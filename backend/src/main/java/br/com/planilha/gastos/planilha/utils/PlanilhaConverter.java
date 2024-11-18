package br.com.planilha.gastos.planilha.utils;

import br.com.planilha.gastos.common.interfaces.MountLinksController;
import br.com.planilha.gastos.planilha.dto.PlanilhaDto;
import br.com.planilha.gastos.planilha.entity.Planilha;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PlanilhaConverter {
  private static final MountLinksController<PlanilhaDto> dtoMountLinksController = new MontadorDeLinksPlanilhaControllerUtil();

  public static PlanilhaDto toDto(Planilha planilha) {
    PlanilhaDto dto = PlanilhaDto.builder()
      .id(planilha.getId())
      .referencia(planilha.getRefencia())
      .build();

    dto.add(dtoMountLinksController.getLinksForDto(dto));

    return dto;
  }

  public static Planilha toEntity(PlanilhaDto planilhaDto) {
    return Planilha.builder()
      .id(planilhaDto.getId())
      .refencia(planilhaDto.getReferencia())
      .build();
  }
}
