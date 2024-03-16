package br.com.book.room.quarto.presentation.quarto.dto.response;

import br.com.book.room.quarto.domain.core.quarto.Quarto;
import br.com.book.room.quarto.presentation.quarto.dto.swagger.QuartoResponseSwagger;

public record QuartoResponse(

) implements QuartoResponseSwagger {


    public static QuartoResponse fromQuartoResponse(Quarto quarto) {

        return null;
    }
}
