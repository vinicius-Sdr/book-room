package br.com.book.room.quarto.applicaton.amenidade.service.impl;

import br.com.book.room.quarto.applicaton.amenidade.service.dto.AmenidadeDto;
import br.com.book.room.quarto.applicaton.validacao.Validador;
import br.com.book.room.quarto.applicaton.validacao.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;

public class AmenidadeCamposObrigatorioImpl implements Validador<AmenidadeDto> {

	@Override
	public void validar(AmenidadeDto amenidadeDto) throws ValidationException {
		if (StringUtils.isBlank(amenidadeDto.descricao())) {
			throw new ValidationException("Campo 'descricao' da amenidade é obrigatório");
		}
	}

}
