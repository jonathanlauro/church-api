package br.com.churchapi.v1.core.produces.impl;


import br.com.churchapi.v1.core.produces.ProdutorDeEntidade;

import javax.ejb.Local;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.ext.Provider;

@Provider
@Local(ProdutorDeEntidade.class)
public class ProdutorDeEntidadeImpl implements ProdutorDeEntidade {

    @PersistenceContext(unitName = "church_api")
    private EntityManager gerenciador;

    @PersistenceUnit(unitName = "church_api")
    private EntityManagerFactory contexto;

    @Produces
    @Override
    public EntityManager getGerenciador() {
        return gerenciador;
    }

    @Produces
    @Override
    public EntityManagerFactory getContexto() {
        return contexto;
    }
}
