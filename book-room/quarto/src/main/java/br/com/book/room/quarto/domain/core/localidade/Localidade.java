package br.com.book.room.quarto.domain.core.localidade;

import java.io.Serializable;

public record Localidade(Long id, String nome, String ruaAv, String numero, String cep, String cidade,
		String estado) implements Serializable {
}