package br.com.churchapi.v1.core.enums;

import javax.persistence.AttributeConverter;

import static br.com.churchapi.v1.core.enums.StatusIgreja.*;
import static java.util.Objects.nonNull;

public class ConversorStatusIgreja implements AttributeConverter<StatusIgreja,String> {
    @Override
    public String convertToDatabaseColumn(StatusIgreja attribute) {
        return nonNull(attribute)
                ? attribute.getStatus()
                : null;
    }

    @Override
    public StatusIgreja convertToEntityAttribute(String dbData) {
        return (nonNull(dbData) && dbData.equals("A"))
                ? ATIVO
                : INATIVO;
    }
}
