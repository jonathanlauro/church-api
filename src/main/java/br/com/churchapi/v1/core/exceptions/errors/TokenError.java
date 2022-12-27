package br.com.churchapi.v1.core.exceptions.errors;

import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocio;
import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocioImpl;

import javax.ws.rs.core.Response;

public enum TokenError implements ErroBase{

    TOKEN_NO_VALID(
            "ERRO! TOKEN INVÁLIDO",
            "CHURCH-API:501001",
            Response.Status.BAD_REQUEST
    )

    ;

    private final ErroNegocio erro;


    TokenError(String menssagem, String cod, Response.Status status) {
        this.erro = new ErroNegocioImpl(cod,menssagem,status);
    }

    @Override
    public ErroNegocio getErro() {
        return erro;
    }
}
