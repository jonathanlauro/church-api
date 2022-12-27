package br.com.churchapi.v1.api.rest.impl;

import br.com.churchapi.v1.api.models.Versao;
import br.com.churchapi.v1.api.rest.VersaoREST;
import br.com.churchapi.v1.core.utils.VersaoUtil;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Logger;

public class VersaoRESTImpl implements VersaoREST {

    private static final Logger log = Logger.getLogger(VersaoRESTImpl.class.toString());

    @Override
    public Response getVersion() throws IOException {
        Versao versao = new Versao(VersaoUtil.get());
        log.info("");
        return Response.ok(versao).build();
    }
}
