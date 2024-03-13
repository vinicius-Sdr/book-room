package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;

public record QuartoItemDto(Long id, QuartoDto quartoDto, Integer quantidade) implements Serializable {
}