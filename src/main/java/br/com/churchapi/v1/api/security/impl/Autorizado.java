package br.com.churchapi.v1.api.security.impl;

import br.com.churchapi.v1.api.security.Auth;
import br.com.churchapi.v1.core.exceptions.NegocioException;
import br.com.churchapi.v1.core.security.FilterTokenJWT;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.io.IOException;

import static java.util.Objects.isNull;

public class Autorizado implements ConstraintValidator<Auth,String> {

    @Inject
    private FilterTokenJWT filterTokenJWT;


    @Override
    public void initialize(Auth constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(isNull(s)){
            return false;
        }else{
            try {
                return filterTokenJWT.validarToken(s);
            } catch (NegocioException | IOException e) {
                e.printStackTrace();
                return false;
            }
        }

    }
}
