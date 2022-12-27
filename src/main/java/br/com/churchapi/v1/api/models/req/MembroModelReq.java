package br.com.churchapi.v1.api.models.req;

import br.com.churchapi.v1.api.models.IgrejaModel;

import java.io.Serializable;

public class MembroModelReq implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String telefone;
    private IgrejaModel igreja;

    public MembroModelReq() {
        this(null,null,null,null);
    }

    public MembroModelReq(String nome, String email, String telefone, IgrejaModel igreja) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.igreja = igreja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public IgrejaModel getIgreja() {
        return igreja;
    }

    public void setIgreja(IgrejaModel igreja) {
        this.igreja = igreja;
    }
}
