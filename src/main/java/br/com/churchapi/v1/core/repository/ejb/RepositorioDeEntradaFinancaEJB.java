package br.com.churchapi.v1.core.repository.ejb;

import br.com.churchapi.v1.core.entidade.EntradasFinanca;
import br.com.churchapi.v1.core.entidade.Igreja;
import br.com.churchapi.v1.core.repository.RepositorioDeEntradaFinanca;

import javax.ejb.Local;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

import static java.util.Objects.nonNull;

@RequestScoped
@Local(RepositorioDeEntradaFinanca.class)
public class RepositorioDeEntradaFinancaEJB implements RepositorioDeEntradaFinanca {

    @Inject
    private EntityManager gerenciador;

    @Override
    @Transactional
    public EntradasFinanca cadastrar(EntradasFinanca entradasFinanca) {
        gerenciador.persist(entradasFinanca);
        gerenciador.flush();
        return entradasFinanca;
    }

    @Override
    public EntradasFinanca atualizar(EntradasFinanca entradasFinanca) {
        if(nonNull(entradasFinanca)){
            EntradasFinanca atualizado = buscar(entradasFinanca.getId());
            atualizado.setValor(entradasFinanca.getValor());
            atualizado.setOrigem(entradasFinanca.getOrigem());
            atualizado.setTipoEntrada(entradasFinanca.getTipoEntrada());
            atualizado.setIgreja(entradasFinanca.getIgreja());
            atualizado.setDataRegistro(entradasFinanca.getDataRegistro());
            gerenciador.merge(atualizado);
            gerenciador.flush();
            return atualizado;
        }
        return null;
    }

    @Override
    public EntradasFinanca deletar(Integer id) {
        EntradasFinanca busca = buscar(id);
        gerenciador.remove(busca);
        return busca;
    }

    @Override
    public List<EntradasFinanca> listarFinancasDaIgreja(Igreja igreja) {
        CriteriaBuilder cb = gerenciador.getCriteriaBuilder();
        CriteriaQuery<EntradasFinanca> cq = cb.createQuery(EntradasFinanca.class);
        Root<EntradasFinanca> root = cq.from(EntradasFinanca.class);
        cq.select(root)
                .where(cb.equal(root.get("igreja").get("id"),igreja.getId()));
        return gerenciador.createQuery(cq).getResultList();
    }
    @Override
    public EntradasFinanca buscar(Integer id){
        return gerenciador.find(EntradasFinanca.class, id);
    }
}
