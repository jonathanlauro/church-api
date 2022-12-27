package br.com.churchapi.v1.api.rest.impl;

import br.com.churchapi.v1.api.conversor.ConversorDeIgreja;
import br.com.churchapi.v1.api.conversor.req.ConversorDeIgrejaREQ;
import br.com.churchapi.v1.api.models.IgrejaModel;
import br.com.churchapi.v1.api.models.req.IgrejaModelReq;
import br.com.churchapi.v1.api.rest.IgrejaREST;
import br.com.churchapi.v1.core.exceptions.BaseException;
import br.com.churchapi.v1.core.service.IgrejaService;

import javax.ejb.Local;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Local(IgrejaREST.class)
public class IgrejaRESTImpl implements IgrejaREST {

    @Inject
    private IgrejaService service;

    @Inject
    private ConversorDeIgreja conversor;

    @Inject
    private ConversorDeIgrejaREQ conversorREQ;

    @Override
    public Response listar(String authorization) {
        return Response.ok(
                conversor.toListModel(service.listar())
        ).build();
    }

    @Override
    public Response cadastrar(String authorization,IgrejaModelReq igreja) throws BaseException {
        return Response.ok(
                conversor.toModel(service.cadastrar(conversorREQ.toEntidade(igreja)))
        ).build();
    }

    @Override
    public Response atualizar(String authorization,IgrejaModel igreja) throws BaseException {
        return Response.ok(
                conversor.toModel(service.atualizar(conversor.toEntidade(igreja)))
        ).build();
    }

    @Override
    public Response buscar(String authorization,Integer id) throws BaseException {
        return Response.ok(
                conversor.toModel(service.buscar(id))
        ).build();
    }

    @Override
    public Response deletar(String authorization ,Integer id) throws BaseException {
        return Response.ok(
                conversor.toModel(service.apagar(id))
        ).build();
    }

    @Override
    public Response buscarComMembros(String authorization, Integer id) throws BaseException {
        return Response.ok(
                service.buscarComMembros(id)
        ).build();
    }
}
