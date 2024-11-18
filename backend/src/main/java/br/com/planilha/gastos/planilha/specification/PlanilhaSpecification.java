package br.com.planilha.gastos.planilha.specification;

import br.com.planilha.gastos.planilha.dto.FiltroPlanilhaDto;
import br.com.planilha.gastos.planilha.entity.Planilha;
import br.com.planilha.gastos.utils.FuncoesGenericas;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlanilhaSpecification implements Specification<Planilha> {
  private FiltroPlanilhaDto filtro;

  @Override
  public Predicate toPredicate(Root<Planilha> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    List<Predicate> list = new ArrayList<>();
    FuncoesGenericas.fazSeNaoForNull(() -> list.add(this.comId(root, criteriaBuilder)), filtro.getId());
    FuncoesGenericas.fazSeNaoForNull(() -> list.add(this.comReferencia(root, criteriaBuilder)), filtro.getReferencia());

    return criteriaBuilder.and(list.toArray(new Predicate[0]));
  }

  private Predicate comId(Root<Planilha> root, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.equal(root.get("id"), filtro.getId());
  }

  private Predicate comReferencia(Root<Planilha> root, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.equal(root.get("referencia"), filtro.getReferencia());
  }
}
