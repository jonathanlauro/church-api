package br.com.churchapi.v1.api.models;

import java.io.Serializable;

public class Versao implements Serializable {
    private static final long serialVersionUID = 1L;

    private String version;

    public Versao() {
        this(null);
    }

    public Versao(String versao) {
        this.version = versao;
    }

    public String getVersao() {
        return version;
    }

    public void setVersao(String versao) {
        this.version = versao;
    }
}
