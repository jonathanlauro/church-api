package br.com.churchapi.v1.core.produces;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface ProdutorDeEntidade {

    EntityManager getGerenciador();

    EntityManagerFactory getContexto();
}
