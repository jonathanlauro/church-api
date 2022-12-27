package br.com.churchapi.v1.api.models;

import br.com.churchapi.v1.api.models.enumsmodel.StatusMembroModel;

import java.io.Serializable;

public class MembroModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nome;

    private String email;

    private String telefone;

    private StatusMembroModel status;

    private IgrejaModel igreja;

    public MembroModel() {
        this(null,null,null,null,null, null);
    }

    public MembroModel(Integer id, String nome, String email, String telefone, StatusMembroModel status, IgrejaModel igreja) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.igreja = igreja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public StatusMembroModel getStatus() {
        return status;
    }

    public void setStatus(StatusMembroModel status) {
        this.status = status;
    }

    public IgrejaModel getIgreja() {
        return igreja;
    }

    public void setIgreja(IgrejaModel igreja) {
        this.igreja = igreja;
    }
}
