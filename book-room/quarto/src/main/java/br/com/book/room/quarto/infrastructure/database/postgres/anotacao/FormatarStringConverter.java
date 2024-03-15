package br.com.book.room.quarto.infrastructure.database.postgres.anotacao;

import br.com.book.room.quarto.infrastructure.string.StringUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FormatarStringConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {
		return StringUtil.trim(StringUtil.formatString(attribute));
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return dbData;
	}

}