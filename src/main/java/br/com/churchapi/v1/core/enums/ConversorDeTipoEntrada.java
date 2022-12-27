package br.com.churchapi.v1.core.enums;

import javax.persistence.AttributeConverter;

import static java.util.Objects.nonNull;

public class ConversorDeTipoEntrada implements AttributeConverter<TipoEntrada,String> {

    @Override
    public String convertToDatabaseColumn(TipoEntrada attribute) {
        return nonNull(attribute)
                ? attribute.getTipo()
                : null;
    }

    @Override
    public TipoEntrada convertToEntityAttribute(String dbData) {
        return (nonNull(dbData) && dbData.equals("DIZIMO"))
                ? TipoEntrada.DIZIMO
                : TipoEntrada.OFERTA;
    }
}
