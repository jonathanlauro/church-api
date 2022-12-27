package br.com.churchapi.v1.api.models;

import br.com.churchapi.v1.api.models.enumsmodel.StatusIgrejaModel;

import java.io.Serializable;

public class IgrejaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nomeFantasia;
    private String cnpj;
    private String endereco;
    private StatusIgrejaModel status;

    public IgrejaModel() {
        this(null,null,null,null,null);
    }

    public IgrejaModel(Integer id, String nomeFantasia, String cnpj, String endereco, StatusIgrejaModel status) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public StatusIgrejaModel getStatus() {
        return status;
    }

    public void setStatus(StatusIgrejaModel status) {
        this.status = status;
    }
}
