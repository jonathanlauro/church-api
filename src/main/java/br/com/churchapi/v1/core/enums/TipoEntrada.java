package br.com.churchapi.v1.core.enums;

public enum TipoEntrada {
    DIZIMO("DIZIMO"),
    OFERTA("OFERTA");

    private final String tipo;

    TipoEntrada(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
