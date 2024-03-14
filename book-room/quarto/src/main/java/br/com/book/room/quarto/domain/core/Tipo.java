package br.com.book.room.quarto.domain.core;

import java.io.Serializable;

public record Tipo(Integer id, String nome, String categoria) implements Serializable {
}