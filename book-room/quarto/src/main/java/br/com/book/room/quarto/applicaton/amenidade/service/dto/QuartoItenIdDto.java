package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;

public record QuartoItenIdDto(Integer id, String tipoItem) implements Serializable {
}