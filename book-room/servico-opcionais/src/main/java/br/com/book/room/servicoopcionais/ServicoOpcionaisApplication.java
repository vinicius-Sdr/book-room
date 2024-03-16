package br.com.book.room.servicoopcionais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServicoOpcionaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicoOpcionaisApplication.class, args);
	}

}
