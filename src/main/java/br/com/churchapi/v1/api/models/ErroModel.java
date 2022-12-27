package br.com.churchapi.v1.api.models;

import javax.ws.rs.core.Response;
import java.io.Serializable;

public class ErroModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String menssagem;
    private Response.Status status;

    public ErroModel(String codigo, String menssagem, Response.Status status) {
        this.codigo = codigo;
        this.menssagem = menssagem;
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    public Response.Status getStatus() {
        return status;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n{\n" +
                "\"codigo\":\"" + codigo + "\",\n" +
                "\"menssagem\":\"" + menssagem + "\",\n" +
                "\"status\":\"" + status + "\"\n"+
                "}";
    }
}
