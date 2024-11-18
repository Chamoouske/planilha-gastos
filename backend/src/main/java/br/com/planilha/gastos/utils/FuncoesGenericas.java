package br.com.planilha.gastos.utils;

import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

@UtilityClass
public class FuncoesGenericas {
  public static <T> void fazSeNaoForNull(Consumer<T> todo, T value) {
    if (Objects.nonNull(value)) todo.accept(value);
  }

  public static <T> void fazSeNaoForNull(Runnable todo, T value) {
    if (Objects.nonNull(value)) todo.run();
  }

  public static <I, O> void converteEFazSeNaoForNull(Function<I, O> convert, Consumer<O> toDo, I value) {
    if (Objects.nonNull(value)) fazSeNaoForNull(toDo, convert.apply(value));
  }
}
