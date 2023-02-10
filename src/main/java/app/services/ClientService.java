package app.services;

import app.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    /* All Owners */
    List<Client> findAll();

    /* Id Owner */
    Optional<Client> findById(Long id);

    /* Insert Owner */
    Client insertClient(Client obj);

    void deleteClientById(Long id);

    Client updateClientById(Long id, Client client);

    void updateClient(Client entity, Client obj);
}
