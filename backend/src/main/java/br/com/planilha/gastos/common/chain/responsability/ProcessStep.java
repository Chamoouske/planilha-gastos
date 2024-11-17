package br.com.planilha.gastos.common.chain.responsability;

import lombok.Setter;

import java.util.Objects;

@Setter
public abstract class ProcessStep {
  private ProcessStep nextStep;

  public ProcessContext next(ProcessContext context, Object result) {
    context.setResult(result);
    return Objects.nonNull(nextStep) ? nextStep.execute(context) : context;
  }

  public abstract ProcessContext execute(ProcessContext context);
}
