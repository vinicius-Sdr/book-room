package br.com.book.room.quarto.applicaton.amenidade.service.dto;

import java.io.Serializable;

public record LocalidadeDto(Integer id, String nome, String ruaAv, String numero, String cep, String cidade,
		String estado) implements Serializable {
}