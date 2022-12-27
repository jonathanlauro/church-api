package br.com.churchapi.v1.api.conversor;

import java.util.List;

public interface Conversor <E,M>{
    E toEntidade(M model);

    M toModel(E entity);

    List<E> toListEntidade(List<M> listModel);

    List<M> toListModel(List<E> listEntidade);
}
