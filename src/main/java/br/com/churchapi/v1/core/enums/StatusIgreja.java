package br.com.churchapi.v1.core.enums;

public enum StatusIgreja {

    ATIVO("A"),
    INATIVO("I");

    private final String status;

    StatusIgreja(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
