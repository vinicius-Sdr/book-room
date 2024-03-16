package br.com.book.room.reservas.service.feign;

import br.com.book.room.reservas.model.cloudModel.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8082/client/", name = "client")
public interface ServicingClient {

	@GetMapping("{id}")
	Client getbyid(@PathVariable("id") Long id);

}
