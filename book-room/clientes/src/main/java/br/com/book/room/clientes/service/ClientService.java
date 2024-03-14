package br.com.book.room.clientes.service;

import br.com.book.room.clientes.model.DTO.ClientDTO;
import br.com.book.room.clientes.model.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ClientService {

    Client createUser(ClientDTO clientDTO);

    List<Client> getAllUsers();

    Client findById(Long id);

    ResponseEntity deleteUser(Long id);

    Client editUser(Long id, ClientDTO clientDTO) throws Exception;

}
