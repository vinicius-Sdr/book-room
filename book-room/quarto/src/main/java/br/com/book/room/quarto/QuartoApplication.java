package br.com.book.room.quarto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.book.room.quarto")
public class QuartoApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartoApplication.class, args);
	}

}
