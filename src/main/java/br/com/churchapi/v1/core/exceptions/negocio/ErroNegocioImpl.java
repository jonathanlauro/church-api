package br.com.churchapi.v1.core.exceptions.negocio;

import javax.ws.rs.core.Response;

public class ErroNegocioImpl implements ErroNegocio{

    private String codigo;
    private String mensagem;
    private Response.Status status;

    public ErroNegocioImpl(String codigo, String mensagem, Response.Status status) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.status = status;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }

    @Override
    public Response.Status getStatus() {
        return status;
    }
}
