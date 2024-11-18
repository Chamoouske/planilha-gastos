package br.com.planilha.gastos.planilha.respository;

import br.com.planilha.gastos.planilha.entity.Planilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlanilhaRepository extends JpaRepository<Planilha, Long>, JpaSpecificationExecutor<Planilha> {
}
