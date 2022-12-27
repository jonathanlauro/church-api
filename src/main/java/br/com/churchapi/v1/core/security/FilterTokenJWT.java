package br.com.churchapi.v1.core.security;

import br.com.churchapi.v1.core.exceptions.NegocioException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface FilterTokenJWT {

    Boolean validarToken(String token) throws NegocioException, IOException;
}
