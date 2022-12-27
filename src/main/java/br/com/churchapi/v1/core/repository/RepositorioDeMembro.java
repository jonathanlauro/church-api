package br.com.churchapi.v1.core.repository;

import br.com.churchapi.v1.core.entidade.Membro;

import java.util.List;

public interface RepositorioDeMembro {

    List<Membro> listar();

    Membro cadastrar(Membro membro);

    Membro atualizar(Membro membro);

    Membro apagar(Membro membro);

    Membro buscar(Integer id);

    List<Membro> listarMembroDaIgrejaEspecifica(Integer idIgreja);
}
