package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

import br.com.book.room.quarto.domain.core.localidade.Localidade;

public record Predio(Integer id, Localidade localidade, String nome) implements Serializable {
}