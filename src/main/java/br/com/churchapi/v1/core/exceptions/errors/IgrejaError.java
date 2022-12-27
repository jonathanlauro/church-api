package br.com.churchapi.v1.core.exceptions.errors;

import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocio;
import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocioImpl;

import javax.ws.rs.core.Response;

public enum IgrejaError implements ErroBase{
    DADOS_IGREJA_INVALIDOS(
            "Erro ao cadastrar Igreja, os dados enviados para cadastro estão incorretos.",
            "CHURCH-API:402001",
            Response.Status.BAD_REQUEST
    ),
    ID_IGREJA_OBRIGATORIO(
            "Erro! Para essa operação o Id é obrigatório.",
            "CHURCH-API:402002",
            Response.Status.BAD_REQUEST
    ),
    IGREJA_NAO_ENCONTRADO(
            "Desculpe, não encontramos a Igreja com o id informado.",
            "CHURCH-API:402003",
            Response.Status.NOT_FOUND
    ),



    ;


    private final ErroNegocio erro;


    IgrejaError(String menssagem, String codigo, Response.Status status ) {
        this.erro = new ErroNegocioImpl(codigo,menssagem, status);
    }

    @Override
    public ErroNegocio getErro() {
        return erro;
    }
}
