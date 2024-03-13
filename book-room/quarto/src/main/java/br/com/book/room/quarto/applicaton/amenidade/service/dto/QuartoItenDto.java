package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;

import br.com.book.room.quarto.infrastructure.database.postgres.entity.QuartoItemIdEntity;

public record QuartoItenDto(QuartoItemIdEntity id, QuartoDto quartoDto, Integer quantidade) implements Serializable {
}