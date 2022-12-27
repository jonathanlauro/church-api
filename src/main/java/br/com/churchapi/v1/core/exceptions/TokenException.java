package br.com.churchapi.v1.core.exceptions;

import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocio;

import javax.ws.rs.core.Response;

import static java.util.Objects.isNull;

public class TokenException extends BaseException{

    private static final String CODE = "CHURCH-API:40000";


    public TokenException(ErroNegocio erro, Throwable cause) {
        super(
                isNull(erro.getMensagem()) ? null : erro.getMensagem(),
                isNull(erro.getStatus()) ? Response.Status.INTERNAL_SERVER_ERROR : erro.getStatus(),
                isNull(erro.getCodigo()) ? CODE : erro.getCodigo(),
                cause);
    }
}
