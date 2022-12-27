package br.com.churchapi.v1.core.service.ejb;

import br.com.churchapi.v1.core.entidade.Igreja;
import br.com.churchapi.v1.core.entidade.Membro;
import br.com.churchapi.v1.core.exceptions.NegocioException;
import br.com.churchapi.v1.core.repository.RepositorioDeIgreja;
import br.com.churchapi.v1.core.repository.RepositorioDeMembro;
import br.com.churchapi.v1.core.service.MembroService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

import static br.com.churchapi.v1.core.exceptions.errors.MembroError.*;
import static java.util.Objects.isNull;

@Stateless
@Local(MembroService.class)
public class MembroServiceEJB implements MembroService {

    @Inject
    private RepositorioDeMembro repository;

    @Inject
    private RepositorioDeIgreja repositorioDeIgreja;


    @Override
    public Membro cadastrar(Membro membro) throws NegocioException {
        validarDadosMembro(membro);
        Igreja igreja = repositorioDeIgreja.buscar(membro.getIgreja().getId());
        if(isNull(igreja)){
            throw new NegocioException(IGREJA_NAO_ENCONTRADO.getErro());
        }
        membro.setIgreja(igreja);
        return repository.cadastrar(membro);
    }

    @Override
    public Membro atualizar(Membro membro) throws NegocioException {
        validarId(membro.getId());
        validarDadosMembro(membro);
        return repository.atualizar(membro);
    }

    @Override
    public List<Membro> listar() {
        return repository.listar();
    }

    @Override
    public Membro deletar(Integer id) throws NegocioException {
        validarId(id);
        Membro busca = repository.buscar(id);
        if(isNull(busca)){
            throw new NegocioException(MEMBRO_NAO_ENCONTRADO.getErro());
        }
        return repository.apagar(busca);
    }

    @Override
    public Membro buscar(Integer id) throws NegocioException {
        validarId(id);
        Membro busca = repository.buscar(id);
        if(isNull(busca)){
            throw new NegocioException(MEMBRO_NAO_ENCONTRADO.getErro());
        }
        return busca;
    }

    private void validarDadosMembro(Membro membro) throws NegocioException {
        if(isNull(membro.getNome()) || membro.getNome().isEmpty() ||
                isNull(membro.getTelefone()) || membro.getTelefone().isEmpty() ||
                isNull(membro.getEmail()) || membro.getEmail().isEmpty() ||
                isNull(membro.getIgreja()) || isNull(membro.getIgreja().getId())
        ) {
            throw new NegocioException(DADOS_INVALIDOS.getErro());
        }
    }

    private void validarId(Integer id) throws NegocioException {
        if (isNull(id)){
            throw new NegocioException(ID_OBRIGATORIO.getErro());
        }
    }
}
