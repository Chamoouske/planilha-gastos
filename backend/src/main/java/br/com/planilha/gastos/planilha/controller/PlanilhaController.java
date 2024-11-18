package br.com.planilha.gastos.planilha.controller;

import br.com.planilha.gastos.common.interfaces.MountLinksController;
import br.com.planilha.gastos.planilha.dto.FiltroPlanilhaDto;
import br.com.planilha.gastos.planilha.dto.PlanilhaDto;
import br.com.planilha.gastos.planilha.service.PlanilhaService;
import br.com.planilha.gastos.planilha.utils.MontadorDeLinksPlanilhaControllerUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/planilha", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PlanilhaController {
  private static final MountLinksController<PlanilhaDto> PLANILHA_DTO_MOUNT_LINKS_CONTROLLER = new MontadorDeLinksPlanilhaControllerUtil();
  private final PlanilhaService planilhaService;

  public static String getSimpleName() {
    return "planilha";
  }

  @GetMapping(value = "buscar")
  @SuppressWarnings("unchecked")
  public ResponseEntity<PagedModel<PlanilhaDto>> getAll(@Valid FiltroPlanilhaDto filtro, Pageable pageable, PagedResourcesAssembler assembler) {
    PagedModel<PlanilhaDto> pagedResourcesAssembler = assembler.toModel(planilhaService.buscar(filtro, pageable));
    pagedResourcesAssembler.add(PLANILHA_DTO_MOUNT_LINKS_CONTROLLER.getAllLinks());

    return ResponseEntity.ok(pagedResourcesAssembler);
  }

  @GetMapping(value = "buscar/{id}")
  public ResponseEntity<PlanilhaDto> getById(@PathVariable Long id) {
    return ResponseEntity.ok(PlanilhaDto.builder().id(id).build());
  }

  @PostMapping(value = "criar")
  public ResponseEntity<PlanilhaDto> post(@Valid @RequestBody PlanilhaDto dto) {
    return new ResponseEntity<>(planilhaService.salvar(dto), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "deletar/{id}")
  public ResponseEntity<Void> delete(@NotBlank @PathVariable Long id) {
    planilhaService.deletar(id);
    return ResponseEntity.ok(null);
  }
}
