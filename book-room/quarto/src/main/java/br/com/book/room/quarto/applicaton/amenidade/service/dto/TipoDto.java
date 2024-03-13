package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;

public record TipoDto(Integer id, String nome, String categoria) implements Serializable {
}