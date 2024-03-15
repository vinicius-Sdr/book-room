package br.com.book.room.clientes.service.impl;


import br.com.book.room.clientes.mapper.ClientMapper;
import br.com.book.room.clientes.model.Client;
import br.com.book.room.clientes.model.DTO.ClientDTO;
import br.com.book.room.clientes.repository.ClientRepository;
import br.com.book.room.clientes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(ClientDTO clientDTO) {

    Client client = ClientMapper.convertToUsuario(clientDTO);
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public ResponseEntity deleteClient(Long id) {
        if (clientRepository.findById(id).isPresent()) {
            clientRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número de Id inválido");
    }

    @Override
    public Client editClient(Long id, ClientDTO clientDTO) throws Exception {
        Optional<Client> ClientOptional = clientRepository.findById(id);
        if (ClientOptional.isPresent()) {
            Client client = ClientMapper.convertToUsuario(clientDTO);
            client.setId(id);
            return clientRepository.save(client);
        } else {
            throw new Exception("Número de id inválido");
        }
    }
}
