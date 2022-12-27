package br.com.churchapi.v1.core.exceptions;

import javax.ws.rs.core.Response;
import java.text.MessageFormat;

import static java.util.Objects.isNull;

public class BaseException extends Exception{

    private static final MessageFormat MENSAGEM_PADRAO = new MessageFormat(
            "Ocorreu um erro no processamento do sistema"
    );
    private final Response.Status status;
    private final String codigo;
    public BaseException(String mensagem, Response.Status status, String codigo, Throwable cause) {
        super(
                isNull(mensagem) ? String.valueOf(MENSAGEM_PADRAO) : mensagem,
                cause
        );
        this.codigo = codigo;
        this.status = status;

    }

    public Response.Status getStatus() {
        return status;
    }

    public String getCodigo() {
        return codigo;
    }
}
