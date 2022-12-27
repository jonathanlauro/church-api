package br.com.churchapi.v1.core.exceptions.errors;

import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocio;
import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocioImpl;

import static javax.ws.rs.core.Response.Status;
import static javax.ws.rs.core.Response.Status.*;

public enum EntradasFinancaError implements ErroBase{
    ENTRADA_FINANCA_NOT_FOUND(
            "Desculpe, não encontramos a entrada.",
            "CHURCH-API:403001",
            NOT_FOUND
    ),
    DADOS_INVALIDOS(
            "Desculpe, dados inválidos, preencha todos os dados corretamente.",
            "CHURCH-API:403001",
            BAD_REQUEST
    ),
    DADOS_INVALIDOS_IGREJA_NAO_EXISTE(
            "Desculpe, dados inválidos, não encontramos a igreja com o numero informado.",
            "CHURCH-API:403001",
            BAD_REQUEST
    )


    ;
    private final ErroNegocio error;

    EntradasFinancaError(String menssagem, String codigo, Status status) {
        this.error = new ErroNegocioImpl(codigo,menssagem,status);
    }

    @Override
    public ErroNegocio getErro() {
        return error;
    }
}
