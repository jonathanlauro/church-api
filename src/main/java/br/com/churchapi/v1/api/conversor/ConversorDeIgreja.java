package br.com.churchapi.v1.api.conversor;

import br.com.churchapi.v1.api.models.IgrejaModel;
import br.com.churchapi.v1.api.models.enumsmodel.StatusIgrejaModel;
import br.com.churchapi.v1.core.entidade.Igreja;
import br.com.churchapi.v1.core.enums.StatusIgreja;
import br.com.churchapi.v1.core.utils.UtilitariosDeConversao;

import javax.inject.Inject;
import java.util.List;

import static java.util.Objects.nonNull;

public class ConversorDeIgreja implements Conversor<Igreja, IgrejaModel>{

    @Inject
    UtilitariosDeConversao conversao;


    @Override
    public Igreja toEntidade(IgrejaModel model) {
        return conversao.converter(this::fromModel, model);
    }

    @Override
    public IgrejaModel toModel(Igreja entity) {
        return conversao.converter(this::fromEntidade, entity);
    }

    @Override
    public List<Igreja> toListEntidade(List<IgrejaModel> listModel) {
        return conversao.converterList(this::fromModel,listModel);
    }

    @Override
    public List<IgrejaModel> toListModel(List<Igreja> listEntidade) {
        return conversao.converterList(this::fromEntidade,listEntidade);
    }


    private Igreja fromModel(IgrejaModel model){
        return new Igreja(
                model.getId(),
                model.getNomeFantasia(),
                model.getCnpj(),
                model.getEndereco(),
                toEntidadeStatus(model.getStatus())
                );
    }

    private IgrejaModel fromEntidade(Igreja entidade){
        return new IgrejaModel(
                entidade.getId(),
                entidade.getNomeFantasia(),
                entidade.getCnpj(),
                entidade.getEndereco(),
                toModelStatus(entidade.getStatus())
        );
    }



    private StatusIgreja toEntidadeStatus(StatusIgrejaModel model) {
        return (nonNull(model) && model.equals(StatusIgrejaModel.ATIVO))
                ? StatusIgreja.ATIVO
                : StatusIgreja.INATIVO;
    }

    private StatusIgrejaModel toModelStatus(StatusIgreja statusIgreja) {
        return (nonNull(statusIgreja) && statusIgreja.getStatus().equals("A"))
                ? StatusIgrejaModel.ATIVO
                : StatusIgrejaModel.INATIVO;
    }
}
