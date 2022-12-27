package br.com.churchapi.v1.core.exceptions.errors;

import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocio;
import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocioImpl;

import javax.ws.rs.core.Response;

public enum MembroError implements ErroBase{

    DADOS_INVALIDOS(
            "Erro ao cadastrar o membro, os dados enviados para cadastro estão incorretos.",
            "CHURCH-API:401001",
            Response.Status.BAD_REQUEST
    ),
    ID_OBRIGATORIO(
            "Erro! Para essa operação o Id é obrigatório.",
            "CHURCH-API:401002",
            Response.Status.BAD_REQUEST
    ),
    MEMBRO_NAO_ENCONTRADO(
            "Desculpe, não encontramos o membro com o id informado.",
            "CHURCH-API:401003",
            Response.Status.NOT_FOUND
    ),
    IGREJA_NAO_ENCONTRADO(
            "Desculpe, não encontramos a igreja informada para realizar o cadastro do membro.",
            "CHURCH-API:401004",
            Response.Status.NOT_FOUND
    ),
    ;

    private final ErroNegocio erro;

    MembroError(String menssagem, String codigo, Response.Status status) {
        this.erro = new ErroNegocioImpl(codigo,menssagem,status);
    }

    @Override
    public ErroNegocio getErro() {
        return erro;
    }
}
