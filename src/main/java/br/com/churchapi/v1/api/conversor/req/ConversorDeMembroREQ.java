package br.com.churchapi.v1.api.conversor.req;

import br.com.churchapi.v1.api.conversor.Conversor;
import br.com.churchapi.v1.api.conversor.ConversorDeIgreja;
import br.com.churchapi.v1.api.models.req.MembroModelReq;
import br.com.churchapi.v1.core.entidade.Membro;
import br.com.churchapi.v1.core.enums.StatusMembro;
import br.com.churchapi.v1.core.utils.UtilitariosDeConversao;

import javax.inject.Inject;
import java.util.List;

public class ConversorDeMembroREQ implements Conversor<Membro, MembroModelReq> {


    @Inject
    private UtilitariosDeConversao conversao;

    @Inject
    private ConversorDeIgreja conversorDeIgreja;

    @Override
    public Membro toEntidade(MembroModelReq model) {
        return conversao.converter(this::fromModel, model);
    }

    @Override
    public MembroModelReq toModel(Membro entity) {
        return null;
    }

    @Override
    public List<Membro> toListEntidade(List<MembroModelReq> listModel) {
        return null;
    }

    @Override
    public List<MembroModelReq> toListModel(List<Membro> listEntidade) {
        return null;
    }

    private Membro fromModel(MembroModelReq membro) {
        return new Membro(
                null,
                membro.getNome(),
                membro.getEmail(),
                membro.getTelefone(),
                StatusMembro.ATIVO,
                conversorDeIgreja.toEntidade(membro.getIgreja())
        );
    }

}
