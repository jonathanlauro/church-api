package br.com.churchapi.v1.core.exceptions;

import br.com.churchapi.v1.api.models.ErroModel;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

import static br.com.churchapi.v1.core.utils.UtilitarioDeMensagem.formatarMenssagemDeErro;

@Provider
public class RestExceptionMapper implements ExceptionMapper<BaseException> {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(RestExceptionMapper.class));

    @Override
    public Response toResponse(BaseException e) {
        ErroModel erroModel = new ErroModel(e.getCodigo(),e.getMessage(),e.getStatus());
        String erro = formatarMenssagemDeErro(erroModel);
        LOGGER.warning(erro);
        return Response.status(e.getStatus()).entity(erroModel).build();
    }



}
