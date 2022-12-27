package br.com.churchapi.v1.core.repository;

import br.com.churchapi.v1.core.entidade.EntradasFinanca;
import br.com.churchapi.v1.core.entidade.Igreja;

import java.util.List;

public interface RepositorioDeEntradaFinanca {

    EntradasFinanca cadastrar(EntradasFinanca entradasFinanca);

    EntradasFinanca atualizar(EntradasFinanca entradasFinanca);

    EntradasFinanca deletar(Integer id);

    List<EntradasFinanca> listarFinancasDaIgreja(Igreja igreja);

    EntradasFinanca buscar(Integer id);
}
