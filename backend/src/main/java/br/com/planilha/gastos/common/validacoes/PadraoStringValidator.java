package br.com.planilha.gastos.common.validacoes;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;
import java.util.regex.Pattern;

public class PadraoStringValidator implements ConstraintValidator<PadraoString, String> {
  private Pattern pattern;

  @Override
  public void initialize(PadraoString constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.pattern = Pattern.compile(constraintAnnotation.pattern().getRegex());
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    boolean valido = true;
    if (Objects.nonNull(s)) {
      valido = pattern.matcher(s).matches();
    }
    return valido;
  }
}
