package app.services.impl;

import app.model.Client;
import app.repositories.ClientRepository;
import app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client insertClient(Client obj) {
        return clientRepository.save(obj);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClientById(Long id, Client client) {
        Client entity = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        updateClient(entity, client);
        return clientRepository.save(entity);
    }

    @Override
    public void updateClient(Client entity, Client obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setAnimals(obj.getAnimals());
        entity.setAddress(obj.getAddress());
    }
}
