package br.com.churchapi.v1.api.rest;

import br.com.churchapi.v1.api.models.MembroModel;
import br.com.churchapi.v1.api.models.req.MembroModelReq;
import br.com.churchapi.v1.core.exceptions.BaseException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/membro")
public interface MembroREST {

    @GET
    @Produces(value = APPLICATION_JSON)
    Response buscarTodos();

    @POST
    @Produces(value = APPLICATION_JSON)
    Response cadastrar(MembroModelReq membro) throws BaseException;

    @PUT
    @Produces(value = APPLICATION_JSON)
    Response atualizar(MembroModel membro) throws BaseException;

    @Path("/{id}")
    @GET
    @Produces(value = APPLICATION_JSON)
    Response buscar(@PathParam(value = "id") Integer id) throws BaseException;

    @Path("/{id}")
    @DELETE
    @Produces(value = APPLICATION_JSON)
    Response deletar(@PathParam(value = "id") Integer id) throws BaseException;

}
