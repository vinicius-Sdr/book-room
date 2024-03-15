package br.com.book.room.quarto.infrastructure.string;

public class StringUtil {

	public static String formatString(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}

		return org.apache.commons.lang3.StringUtils.capitalize(input.toLowerCase());
	}

	public static String trim(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}

		return org.apache.commons.lang3.StringUtils.trim(input);
	}

}