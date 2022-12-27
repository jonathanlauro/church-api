package br.com.churchapi.v1.core.exceptions.negocio;

import javax.ws.rs.core.Response;

public interface ErroNegocio {
    String getCodigo();
    String getMensagem();
    Response.Status getStatus();
}
