package br.com.planilha.gastos.common.interfaces;

import org.springframework.hateoas.Link;

import java.util.List;

public interface MountLinksController<T> {
  List<Link> getLinksForDto(T dto);
  List<Link> getAllLinks();
}
