package br.com.planilha.gastos.common.chain.responsability;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;


public final class ProcessContext {
  private final HashMap<Object, Object> hashMap = new LinkedHashMap<>();
  @Getter
  @Setter
  private Object result;

  public void add(Object key, Object value) {
    hashMap.put(key, value);
  }

  public Object get(Object key) {
    return hashMap.get(key);
  }
}
