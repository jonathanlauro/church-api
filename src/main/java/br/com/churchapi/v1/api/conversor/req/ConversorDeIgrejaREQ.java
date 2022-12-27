package br.com.churchapi.v1.api.conversor.req;

import br.com.churchapi.v1.api.conversor.Conversor;
import br.com.churchapi.v1.api.models.req.IgrejaModelReq;
import br.com.churchapi.v1.core.entidade.Igreja;
import br.com.churchapi.v1.core.enums.StatusIgreja;
import br.com.churchapi.v1.core.utils.UtilitariosDeConversao;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class ConversorDeIgrejaREQ implements Conversor<Igreja, IgrejaModelReq> {

    @Inject
    private UtilitariosDeConversao conversao;

    @Override
    public Igreja toEntidade(IgrejaModelReq model) {
        return conversao.converter(this::fromModelo, model);
    }

    @Override
    public IgrejaModelReq toModel(Igreja entity) {
        return null;
    }

    @Override
    public List<Igreja> toListEntidade(List<IgrejaModelReq> listModel) {
        return Collections.emptyList();
    }

    @Override
    public List<IgrejaModelReq> toListModel(List<Igreja> listEntidade) {
        return Collections.emptyList();
    }

    private Igreja fromModelo(IgrejaModelReq model) {
        return new Igreja(
                null,
                model.getNomeFantasia(),
                model.getCnpj(),
                model.getEndereco(),
                StatusIgreja.ATIVO
        );
    }
}
