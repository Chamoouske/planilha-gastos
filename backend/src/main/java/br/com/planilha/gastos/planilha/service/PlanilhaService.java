package br.com.planilha.gastos.planilha.service;

import br.com.planilha.gastos.planilha.dto.FiltroPlanilhaDto;
import br.com.planilha.gastos.planilha.dto.PlanilhaDto;
import br.com.planilha.gastos.planilha.entity.Planilha;
import br.com.planilha.gastos.planilha.respository.PlanilhaRepository;
import br.com.planilha.gastos.planilha.specification.PlanilhaSpecification;
import br.com.planilha.gastos.planilha.utils.PlanilhaConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlanilhaService {
  private final PlanilhaRepository repository;

  public Page<PlanilhaDto> buscar(FiltroPlanilhaDto dto, Pageable pageable) {
    Page<Planilha> planilhaPage = repository.findAll(new PlanilhaSpecification(dto), pageable);

    return new PageImpl<>(planilhaPage.stream().map(PlanilhaConverter::toDto).toList(), pageable, planilhaPage.getTotalElements());
  }

  @Transactional
  public PlanilhaDto salvar(PlanilhaDto planilhaDto) {
    return PlanilhaConverter.toDto(repository.save(PlanilhaConverter.toEntity(planilhaDto)));
  }

  @Transactional
  public void deletar(Long id) {
    repository.delete(new PlanilhaSpecification(FiltroPlanilhaDto.builder().id(id).build()));
  }
}
