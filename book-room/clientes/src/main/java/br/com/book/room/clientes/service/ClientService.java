package br.com.book.room.clientes.service;

import br.com.book.room.clientes.model.DTO.ClientDTO;
import br.com.book.room.clientes.model.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ClientService {

    Client createClient(ClientDTO clientDTO);

    List<Client> getAllClients();

    Client findById(Long id);

    ResponseEntity deleteClient(Long id);

    Client editClient(Long id, ClientDTO clientDTO) throws Exception;

}
