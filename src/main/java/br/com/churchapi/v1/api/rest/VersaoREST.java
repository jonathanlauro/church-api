package br.com.churchapi.v1.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Path("/versao")
public interface VersaoREST {

    @GET
    @Produces(value = APPLICATION_JSON)
    Response getVersion() throws IOException;
}
