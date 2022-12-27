package br.com.churchapi.v1.core.repository.ejb;

import br.com.churchapi.v1.core.entidade.Membro;
import br.com.churchapi.v1.core.repository.RepositorioDeMembro;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javax.ejb.Local;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Local(RepositorioDeMembro.class)
public class RepositorioDeMembroEJB implements RepositorioDeMembro {

    @Inject
    private EntityManager gerenciador;


    @Override
    public List<Membro> listar() {
        CriteriaBuilder cb = gerenciador.getCriteriaBuilder();
        CriteriaQuery<Membro> cq = cb.createQuery(Membro.class);
        Root<Membro> root = cq.from(Membro.class);
        cq.select(root);
        return gerenciador.createQuery(cq).getResultList();
    }

    @Transactional
    @Override
    public Membro cadastrar(Membro membro) {
        gerenciador.persist(membro);
        gerenciador.flush();
        return membro;
    }

    @Transactional
    @Override
    public Membro atualizar(Membro membro) {
        Membro busca = buscar(membro.getId());
        busca.setId(membro.getId());
        busca.setNome(membro.getNome());
        busca.setEmail(membro.getEmail());
        busca.setTelefone(membro.getTelefone());
        busca.setStatus(membro.getStatus());
        gerenciador.merge(busca);
        gerenciador.flush();
        return membro;
    }

    @Override
    public Membro apagar(Membro membro) {
        gerenciador.remove(membro);
        return membro;
    }

    @Override
    public Membro buscar(Integer id) {
        return gerenciador.find(Membro.class,id);
    }

    @Override
    public List<Membro> listarMembroDaIgrejaEspecifica(Integer idIgreja) {
        CriteriaBuilder cb = gerenciador.getCriteriaBuilder();
        CriteriaQuery<Membro> cq = cb.createQuery(Membro.class);
        Root<Membro> root = cq.from(Membro.class);
        cq.select(root)
                .where(cb.equal(root.get("igreja").get("id"), idIgreja));
        return gerenciador.createQuery(cq).getResultList();
    }
}
