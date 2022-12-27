package br.com.churchapi.v1.core.service.ejb;

import br.com.churchapi.v1.api.conversor.ConversorDeIgreja;
import br.com.churchapi.v1.api.conversor.ConversorDeMembro;
import br.com.churchapi.v1.api.models.IgrejaComMembrosModel;
import br.com.churchapi.v1.api.models.IgrejaModel;
import br.com.churchapi.v1.api.models.MembroModel;
import br.com.churchapi.v1.core.entidade.Igreja;
import br.com.churchapi.v1.core.enums.StatusIgreja;
import br.com.churchapi.v1.core.exceptions.NegocioException;
import br.com.churchapi.v1.core.repository.RepositorioDeIgreja;
import br.com.churchapi.v1.core.repository.RepositorioDeMembro;
import br.com.churchapi.v1.core.service.IgrejaService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

import static br.com.churchapi.v1.core.exceptions.errors.IgrejaError.*;
import static java.util.Objects.isNull;

@Stateless
@Local(IgrejaService.class)
public class IgrejaServiceEJB implements IgrejaService {

    @Inject
    private RepositorioDeIgreja repository;

    @Inject
    private RepositorioDeMembro repositorioDeMembro;

    @Inject
    private ConversorDeMembro conversorDeMembro;

    @Inject
    private ConversorDeIgreja conversorDeIgreja;

    @Override
    public List<Igreja> listar() {
        return repository.listar();
    }

    @Override
    public Igreja cadastrar(Igreja igreja) throws NegocioException {
        validaIgreja(igreja);
        igreja.setStatus(StatusIgreja.ATIVO);
        return repository.cadastrar(igreja);
    }

    @Override
    public Igreja atualizar(Igreja igreja) throws NegocioException {
        validaId(igreja.getId());
        validaIgreja(igreja);
        Igreja busca = repository.buscar(igreja.getId());
        if(isNull(busca)){
            throw new NegocioException(IGREJA_NAO_ENCONTRADO.getErro());
        }
        return repository.atualizar(igreja);
    }

    @Override
    public Igreja apagar(Integer id) throws NegocioException {
        validaId(id);
        Igreja busca = repository.buscar(id);
        if(isNull(busca)){
            throw new NegocioException(IGREJA_NAO_ENCONTRADO.getErro());
        }
        return repository.apagar(busca);
    }

    @Override
    public Igreja buscar(Integer id) throws NegocioException {
        Igreja busca = repository.buscar(id);
        if(isNull(busca)){
            throw new NegocioException(IGREJA_NAO_ENCONTRADO.getErro());
        }
        return busca;
    }

    @Override
    public IgrejaComMembrosModel buscarComMembros(Integer id) throws NegocioException {
        List<MembroModel> membroModel = conversorDeMembro.toListModel(repositorioDeMembro.listarMembroDaIgrejaEspecifica(id));
        IgrejaModel igreja = conversorDeIgreja.toModel(buscar(id));
        return new IgrejaComMembrosModel(igreja,membroModel);
    }


    private void validaIgreja(Igreja igreja) throws NegocioException {
        if(isNull(igreja.getNomeFantasia()) || igreja.getNomeFantasia().isEmpty() ||
                isNull(igreja.getCnpj()) || igreja.getCnpj().length() != 14 ||
                isNull(igreja.getEndereco()) || igreja.getEndereco().isEmpty()
        ){
            throw new NegocioException(DADOS_IGREJA_INVALIDOS.getErro());
        }
    }

    private void validaId(Integer id) throws NegocioException{
        if(isNull(id)){
            throw new NegocioException(ID_IGREJA_OBRIGATORIO.getErro());
        }
    }
}
