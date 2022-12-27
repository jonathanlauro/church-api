package br.com.churchapi.v1.core.exceptions;

import br.com.churchapi.v1.api.models.ErroModel;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static br.com.churchapi.v1.core.utils.UtilitarioDeMensagem.formatarMenssagemDeErro;

@Provider
public class AuthExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    private static final String CODIGO_ERRO = "CHURCH-API:400001";
    private static final Logger LOGGER = Logger.getLogger(AuthExceptionMapper.class.toString());
    @Override
    public Response toResponse(ConstraintViolationException e) {
        List<String> erros = new ArrayList<>();
        e.getConstraintViolations().forEach(err -> erros.add(err.getMessage()));
        String mensagem = erros.stream().reduce("", String::concat);
        ErroModel erroModel = new ErroModel(CODIGO_ERRO,mensagem, Response.Status.UNAUTHORIZED);
        String menssagemLogger = formatarMenssagemDeErro(erroModel);
        LOGGER.warning(menssagemLogger);
        return Response.status(erroModel.getStatus()).entity(erroModel).build();
    }
}
