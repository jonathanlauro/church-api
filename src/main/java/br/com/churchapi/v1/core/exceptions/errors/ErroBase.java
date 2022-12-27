package br.com.churchapi.v1.core.exceptions.errors;

import br.com.churchapi.v1.core.exceptions.negocio.ErroNegocio;

public interface ErroBase {
    ErroNegocio getErro();
}
