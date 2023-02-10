package app.services.impl;

import app.exception.BusinessRuleException;
import app.model.Client;
import app.repositories.ClientRepository;
import app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        if (clientRepository.findAll().isEmpty()) {
            throw new BusinessRuleException("List is Empty");
        }

        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new BusinessRuleException("Client ID not found."));
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
        Client entity = clientRepository.findById(id).orElseThrow(() -> new BusinessRuleException("Client ID not found."));
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
