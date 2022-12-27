package br.com.churchapi.v1.api.rest;

import br.com.churchapi.v1.api.models.IgrejaModel;
import br.com.churchapi.v1.api.models.req.IgrejaModelReq;
import br.com.churchapi.v1.api.security.Auth;
import br.com.churchapi.v1.core.exceptions.BaseException;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/igreja")
public interface IgrejaREST {

    @GET
    @Produces(value = APPLICATION_JSON)
    Response listar(@Valid @HeaderParam("Authorization") @Auth String authorization);

    @POST
    @Produces(value = APPLICATION_JSON)
    Response cadastrar(@Valid @HeaderParam("Authorization") @Auth String authorization, IgrejaModelReq igreja) throws BaseException;

    @PUT
    @Produces(value = APPLICATION_JSON)
    Response atualizar(@Valid @HeaderParam("Authorization") @Auth String authorization,IgrejaModel igreja) throws BaseException;

    @Path("/{id}")
    @GET
    @Produces(value = APPLICATION_JSON)
    Response buscar(@Valid @HeaderParam("Authorization") @Auth String authorization,@PathParam(value = "id") Integer id) throws BaseException;

    @Path("/{id}")
    @DELETE
    @Produces(value = APPLICATION_JSON)
    Response deletar(@Valid @HeaderParam("Authorization") @Auth String authorization ,@PathParam(value = "id") Integer id) throws BaseException;

    @Path("/{id}/com-membros")
    @GET
    @Produces(value = APPLICATION_JSON)
    Response buscarComMembros(@Valid @HeaderParam("Authorization") @Auth String authorization,@PathParam("id") Integer id) throws BaseException;
}
