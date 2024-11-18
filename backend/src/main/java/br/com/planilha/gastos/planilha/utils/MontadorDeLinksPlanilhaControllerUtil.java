package br.com.planilha.gastos.planilha.utils;

import br.com.planilha.gastos.common.interfaces.MountLinksController;
import br.com.planilha.gastos.planilha.controller.PlanilhaController;
import br.com.planilha.gastos.planilha.dto.PlanilhaDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.ArrayList;
import java.util.List;

public class MontadorDeLinksPlanilhaControllerUtil implements MountLinksController<PlanilhaDto> {
  @Override
  public List<Link> getLinksForDto(PlanilhaDto dto) {
    List<Link> links = new ArrayList<>();

    links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlanilhaController.class).getById(dto.getId())).withSelfRel());
    links.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlanilhaController.class).delete(dto.getId())).withSelfRel());

    return links;
  }

  @Override
  public List<Link> getAllLinks() {
    List<Link> links = new ArrayList<>();
    links.add(
      WebMvcLinkBuilder.linkTo(
        WebMvcLinkBuilder.methodOn(PlanilhaController.class).post(
          PlanilhaDto.builder().build()
        )
      ).withSelfRel()
    );

    return links;
  }
}
