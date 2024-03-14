package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

public record Predio(Integer id, Localidade localidade, String nome) implements Serializable {
}