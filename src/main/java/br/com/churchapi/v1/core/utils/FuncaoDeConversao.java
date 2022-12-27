package br.com.churchapi.v1.core.utils;

public interface FuncaoDeConversao <F,T>{
    T apply(F from);
}
