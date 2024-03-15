package br.com.book.room.quarto.infrastructure.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtil {

	public static String capitalizeWords(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}

		return Arrays.stream(input.strip().split("\\s+"))
			.map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
			.collect(Collectors.joining(" "));
	}

	public static String trim(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}

		return input.strip();
	}

}