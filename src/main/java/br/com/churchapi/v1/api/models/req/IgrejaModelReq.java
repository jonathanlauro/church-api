package br.com.churchapi.v1.api.models.req;

import java.io.Serializable;

public class IgrejaModelReq implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nomeFantasia;
    private String cnpj;
    private String endereco;

    public IgrejaModelReq() {
        this(null,null,null);
    }

    public IgrejaModelReq(String nomeFantasia, String cnpj, String endereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
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

}
