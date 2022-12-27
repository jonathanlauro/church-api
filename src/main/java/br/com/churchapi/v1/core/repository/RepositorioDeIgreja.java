package br.com.churchapi.v1.core.repository;

import br.com.churchapi.v1.core.entidade.Igreja;

import java.util.List;

public interface RepositorioDeIgreja {
    
    List<Igreja> listar();

    Igreja cadastrar(Igreja igreja);

    Igreja atualizar(Igreja igreja);

    Igreja apagar(Igreja igreja);

    Igreja buscar(Integer id);
}
