package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;

public record PredioDto(Integer id, LocalidadeDto localidadeDto, String nome) implements Serializable {
}