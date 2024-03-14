package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

public record Localidade(Integer id, String nome, String ruaAv, String numero, String cep, String cidade,
		String estado) implements Serializable {
}