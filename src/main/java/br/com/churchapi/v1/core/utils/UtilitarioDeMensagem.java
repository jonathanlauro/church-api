package br.com.churchapi.v1.core.utils;

import br.com.churchapi.v1.api.models.ErroModel;

import javax.ws.rs.core.Response;

public class UtilitarioDeMensagem {



    public static String formatarMenssagemDeErro(ErroModel erroModel) {
        String erro = erroModel.toString();
        if(erroModel.getStatus().equals(Response.Status.NOT_FOUND)){
            return "\u001B[33m" + erro + "\u001B[0m";
        }else{
            return "\u001B[31m" + erro +"\u001B[0m";
        }
    }
}
