package br.com.churchapi.v1.core.enums;

public enum StatusMembro {

    ATIVO(1),
    INATIVO(0)
    ;

    private final Integer status;

    StatusMembro(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
