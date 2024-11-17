package br.com.planilha.gastos.common.validacoes;

import jakarta.validation.Constraint;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PadraoStringValidator.class})
public @interface PadraoString {
  @OverridesAttribute(constraint = NotNull.class, name = "message")
  String message() default "{}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  PadroesValidacoesEnum pattern();
}
