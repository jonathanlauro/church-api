package br.com.churchapi.v1.core.repository.ejb;

import br.com.churchapi.v1.core.entidade.Igreja;
import br.com.churchapi.v1.core.repository.RepositorioDeIgreja;

import javax.ejb.Local;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Local(RepositorioDeIgreja.class)
public class RepositorioDeIgrejaEJB implements RepositorioDeIgreja {

    @Inject
    private EntityManager gerenciador;


    @Override
    public List<Igreja> listar() {
        CriteriaBuilder cb = gerenciador.getCriteriaBuilder();
        CriteriaQuery<Igreja> cq = cb.createQuery(Igreja.class);
        Root<Igreja> root = cq.from(Igreja.class);
        cq.select(root);
        return gerenciador.createQuery(cq).getResultList();
    }

    @Override
    @Transactional
    public Igreja cadastrar(Igreja igreja) {
        gerenciador.persist(igreja);
        gerenciador.flush();
        return igreja;
    }

    @Override
    public Igreja atualizar(Igreja igreja) {
        Igreja busca = buscar(igreja.getId());
        busca.setId(igreja.getId());
        busca.setNomeFantasia(igreja.getNomeFantasia());
        busca.setCnpj(igreja.getCnpj());
        busca.setEndereco(igreja.getEndereco());
        gerenciador.merge(busca);
        gerenciador.flush();
        return busca;
    }

    @Override
    public Igreja apagar(Igreja igreja) {
        gerenciador.remove(igreja);
        return igreja;
    }

    @Override
    public Igreja buscar(Integer id) {
        return gerenciador.find(Igreja.class,id);
    }
}
