package br.com.planilha.gastos.common.chain.responsability;

public class ChainBuilder {
  private ChainBuilder() {
  }

  public static ProcessStep buildChain(ProcessStep... steps) {
    for (int i = 0; i < steps.length - 1; i++) {
      steps[i].setNextStep(steps[i + 1]);
    }

    return steps[0];
  }

  public static Object runChain(ProcessStep initialStep, ProcessContext initialContext) {
    return initialStep.execute(initialContext).getResult();
  }
}
