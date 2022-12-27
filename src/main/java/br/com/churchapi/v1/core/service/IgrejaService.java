package br.com.churchapi.v1.core.service;

import br.com.churchapi.v1.api.models.IgrejaComMembrosModel;
import br.com.churchapi.v1.core.entidade.Igreja;
import br.com.churchapi.v1.core.exceptions.NegocioException;

import java.util.List;

public interface IgrejaService {
    List<Igreja> listar();

    Igreja cadastrar(Igreja igreja) throws NegocioException;

    Igreja atualizar(Igreja igreja) throws NegocioException;

    Igreja apagar(Integer id) throws NegocioException;

    Igreja buscar(Integer id) throws NegocioException;

    IgrejaComMembrosModel buscarComMembros(Integer id) throws NegocioException;
}
