package br.com.churchapi.v1.core.service.ejb;

import br.com.churchapi.v1.core.entidade.EntradasFinanca;
import br.com.churchapi.v1.core.entidade.Igreja;
import br.com.churchapi.v1.core.exceptions.NegocioException;
import br.com.churchapi.v1.core.repository.RepositorioDeEntradaFinanca;
import br.com.churchapi.v1.core.repository.RepositorioDeIgreja;
import br.com.churchapi.v1.core.service.EntradasFinancaService;

import javax.ejb.Local;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static br.com.churchapi.v1.core.exceptions.errors.EntradasFinancaError.DADOS_INVALIDOS;
import static br.com.churchapi.v1.core.exceptions.errors.EntradasFinancaError.DADOS_INVALIDOS_IGREJA_NAO_EXISTE;
import static java.util.Objects.isNull;

@Named
@Local(EntradasFinancaService.class)
public class EntradasFinancaServiceEJB implements EntradasFinancaService{

    @Inject
    private RepositorioDeEntradaFinanca repository;

    @Inject
    private RepositorioDeIgreja repositorioDeIgreja;

    @Override
    public EntradasFinanca cadastrar(EntradasFinanca entradasFinanca) throws NegocioException {
        validarEntradasFinancas(entradasFinanca);
        entradasFinanca.setDataRegistro(new Date());
        return repository.cadastrar(entradasFinanca);
    }

    @Override
    public EntradasFinanca atualizar(EntradasFinanca entradasFinanca) throws NegocioException {
        validarId(entradasFinanca.getId());
        validarEntradasFinancas(entradasFinanca);
        return repository.atualizar(entradasFinanca);
    }

    @Override
    public EntradasFinanca deletar(Integer id) throws NegocioException {
        validarId(id);
        return repository.deletar(id);
    }

    @Override
    public List<EntradasFinanca> listarFinancasDaIgreja(Integer idIgreja) throws NegocioException {

        Igreja busca = repositorioDeIgreja.buscar(idIgreja);
        if(isNull(busca)){
            throw new NegocioException(DADOS_INVALIDOS_IGREJA_NAO_EXISTE.getErro());
        }
        return repository.listarFinancasDaIgreja(busca);
    }

    @Override
    public EntradasFinanca buscar(Integer id) throws NegocioException {
        validarId(id);
        return repository.buscar(id);
    }


    private void validarEntradasFinancas(EntradasFinanca entradasFinanca) throws NegocioException {
        if(entradasFinanca.getValor().equals(BigDecimal.ZERO)){
            throw new NegocioException(DADOS_INVALIDOS.getErro());
        }
        if(isNull(entradasFinanca.getOrigem()) || entradasFinanca.getOrigem().isEmpty()){
            throw new NegocioException(DADOS_INVALIDOS.getErro());
        }
        if(isNull(entradasFinanca.getTipoEntrada())) {
            throw new NegocioException(DADOS_INVALIDOS.getErro());
        }
        if(isNull(entradasFinanca.getIgreja()) || isNull(entradasFinanca.getIgreja().getId())) {
            throw new NegocioException(DADOS_INVALIDOS.getErro());
        }

    }

    private void validarId(Integer id) throws NegocioException {
        if(isNull(id)) {
            throw new NegocioException(DADOS_INVALIDOS.getErro());
        }
    }
}
