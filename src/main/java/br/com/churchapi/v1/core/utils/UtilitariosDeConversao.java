package br.com.churchapi.v1.core.utils;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Stateless
public class UtilitariosDeConversao{

    public <F,T> T converter( FuncaoDeConversao<F,T> funcao, F from ){
        return nonNull(from) ? funcao.apply(from) : null;
    }
    public <F,T> List<T> converterList (FuncaoDeConversao<F,T> funcao, Iterable<F> from){
        if(nonNull(from)) {
            List<T> retorno = new ArrayList<>();
            from.forEach(e -> {
                if(nonNull(e)){
                    retorno.add(funcao.apply(e));
                }
            });
            return retorno;
        }else{
            return null;
        }
    }
}
