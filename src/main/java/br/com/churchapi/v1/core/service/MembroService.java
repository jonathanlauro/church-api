package br.com.churchapi.v1.core.service;

import br.com.churchapi.v1.core.entidade.Membro;
import br.com.churchapi.v1.core.exceptions.NegocioException;

import java.util.List;

public interface MembroService {

    Membro cadastrar(Membro membro) throws NegocioException;

    Membro atualizar(Membro membro) throws NegocioException;

    List<Membro> listar();

    Membro deletar(Integer id) throws NegocioException;

    Membro buscar(Integer id) throws NegocioException;
}
