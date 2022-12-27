package br.com.churchapi.v1.api.rest.impl;

import br.com.churchapi.v1.api.conversor.ConversorDeMembro;
import br.com.churchapi.v1.api.conversor.req.ConversorDeMembroREQ;
import br.com.churchapi.v1.api.models.MembroModel;
import br.com.churchapi.v1.api.models.req.MembroModelReq;
import br.com.churchapi.v1.api.rest.MembroREST;
import br.com.churchapi.v1.core.exceptions.BaseException;
import br.com.churchapi.v1.core.service.MembroService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class MembroRESTImpl implements MembroREST {

    @Inject
    private MembroService service;

    @Inject
    private ConversorDeMembro conversor;

    @Inject
    private ConversorDeMembroREQ conversorDeMembroREQ;

    @Override
    public Response buscarTodos() {
        return Response.ok(
                conversor.toListModel(service.listar())
        ).build();
    }

    @Override
    public Response cadastrar(MembroModelReq membro) throws BaseException {
        return Response.ok(
                conversor.toModel(service.cadastrar(conversorDeMembroREQ.toEntidade(membro)))
        ).build();
    }

    @Override
    public Response atualizar(MembroModel membro) throws BaseException {
        return Response.ok(
                conversor.toModel(service.atualizar(conversor.toEntidade(membro)))
        ).build();
    }

    @Override
    public Response buscar(Integer id) throws BaseException {
        return Response.ok(
                conversor.toModel(service.buscar(id))
        ).build();
    }

    @Override
    public Response deletar(Integer id) throws BaseException {
        return Response.ok(
                conversor.toModel(service.deletar(id))
        ).build();
    }
}
