package br.com.churchapi.v1.core.security.impl;

import br.com.churchapi.v1.core.exceptions.NegocioException;
import br.com.churchapi.v1.core.security.FilterTokenJWT;

import javax.ejb.Local;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static br.com.churchapi.v1.core.exceptions.errors.TokenError.TOKEN_NO_VALID;

@Provider
@Local(FilterTokenJWTImpl.class)
public class FilterTokenJWTImpl implements FilterTokenJWT {

    @Override
    public Boolean validarToken(String token) throws NegocioException, IOException {
        String tokenSemBearer = validarPeloBearer(token);
        String[] tokenSeparado = tokenSemBearer.split("\\.");
        List<String> tokenParts = new ArrayList<>(Arrays.asList(tokenSeparado));
        if(tokenParts.size() != 3){
            return Boolean.FALSE;
        }else{
            URL url = new URL("http://192.168.0.130:8080/auth/realms/master/protocol/openid-connect/userinfo");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + tokenSemBearer);
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            int status = con.getResponseCode();

            if(status == 200){
                return Boolean.TRUE;
            }else {
                return Boolean.FALSE;
            }


        }
    }
    private String validarPeloBearer(String token) throws NegocioException {
        String[] tokenSplit = token.split(" ");
        Set<String> tokenSemPalavarBearerRepetida = new HashSet<>(Arrays.asList(tokenSplit));
        if(tokenSemPalavarBearerRepetida.contains("Bearer")){
            tokenSemPalavarBearerRepetida.remove("Bearer");
            return tokenSemPalavarBearerRepetida.stream().reduce("",String::concat);
        }else {
            throw new NegocioException(TOKEN_NO_VALID.getErro());
        }
    }
}


