package br.com.churchapi.v1.core.service;

import br.com.churchapi.v1.core.entidade.EntradasFinanca;
import br.com.churchapi.v1.core.exceptions.NegocioException;

import java.math.BigInteger;
import java.util.List;

public interface EntradasFinancaService {

    EntradasFinanca cadastrar(EntradasFinanca entradasFinanca) throws NegocioException;

    EntradasFinanca atualizar(EntradasFinanca entradasFinanca) throws NegocioException;

    EntradasFinanca deletar(Integer id) throws NegocioException;

    List<EntradasFinanca> listarFinancasDaIgreja(Integer idIgreja) throws NegocioException;

    EntradasFinanca buscar(Integer id) throws NegocioException;
}
