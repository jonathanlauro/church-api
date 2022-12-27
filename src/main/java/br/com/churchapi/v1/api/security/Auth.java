package br.com.churchapi.v1.api.security;

import br.com.churchapi.v1.api.security.impl.Autorizado;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Constraint(validatedBy = Autorizado.class)
public @interface Auth {

    String message() default "Não Autorizado!";
    Class<?> [] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
