package br.com.churchapi.v1.core.enums;

import javax.persistence.AttributeConverter;

import static java.util.Objects.nonNull;

public class ConversorStatus implements AttributeConverter<StatusMembro,Integer> {


    @Override
    public Integer convertToDatabaseColumn(StatusMembro statusMembro) {
        return nonNull(statusMembro)
                ? statusMembro.getStatus()
                : null;
    }

    @Override
    public StatusMembro convertToEntityAttribute(Integer integer) {
        return (nonNull(integer) && integer == 1)
                ? StatusMembro.ATIVO
                : StatusMembro.INATIVO;
    }
}
