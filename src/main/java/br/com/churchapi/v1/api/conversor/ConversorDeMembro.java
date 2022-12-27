package br.com.churchapi.v1.api.conversor;

import br.com.churchapi.v1.api.models.MembroModel;
import br.com.churchapi.v1.api.models.enumsmodel.StatusMembroModel;
import br.com.churchapi.v1.core.entidade.Membro;
import br.com.churchapi.v1.core.enums.StatusMembro;
import br.com.churchapi.v1.core.utils.UtilitariosDeConversao;

import javax.inject.Inject;
import java.util.List;

public class ConversorDeMembro implements Conversor<Membro, MembroModel>{

    @Inject
    private UtilitariosDeConversao conversor;

    @Inject
    private ConversorDeIgreja conversorDeIgreja;

    @Override
    public Membro toEntidade(MembroModel model) {
        return conversor.converter(this::fromModel,model);
    }

    @Override
    public MembroModel toModel(Membro entity) {
        return conversor.converter(this::fromEntidade, entity);
    }

    @Override
    public List<Membro> toListEntidade(List<MembroModel> listModel) {
        return conversor.converterList(this::fromModel,listModel);
    }

    @Override
    public List<MembroModel> toListModel(List<Membro> listEntidade) {
        return conversor.converterList(this::fromEntidade, listEntidade);
    }

    private MembroModel fromEntidade(Membro membro) {
        return new MembroModel(
                membro.getId(),
                membro.getNome(),
                membro.getEmail(),
                membro.getTelefone(),
                toStatusModelo(membro.getStatus()),
                conversorDeIgreja.toModel(membro.getIgreja())
        );
    }
    private Membro fromModel(MembroModel membro) {
        return new Membro(
                membro.getId(),
                membro.getNome(),
                membro.getEmail(),
                membro.getTelefone(),
                toStatusEntidade(membro.getStatus()),
                conversorDeIgreja.toEntidade(membro.getIgreja())
        );
    }

    private StatusMembroModel toStatusModelo(StatusMembro status) {
        if(status.getStatus() == 1){
            return StatusMembroModel.ATIVO;
        }else {
            return StatusMembroModel.INATIVO;
        }
    }
    private StatusMembro toStatusEntidade(StatusMembroModel status) {
        if(status == StatusMembroModel.ATIVO) {
            return StatusMembro.ATIVO;
        }else {
            return StatusMembro.INATIVO;
        }
    }
}
