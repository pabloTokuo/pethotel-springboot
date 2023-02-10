package app.controller;

import app.model.Client;
import app.services.impl.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pethotel/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @GetMapping
    public List<Client> findAllClients() {
        return clientServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return clientServiceImpl.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertClient(@RequestBody @Valid Client client) {
        return clientServiceImpl.insertClient(client);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientByid(@PathVariable Long id) {
        clientServiceImpl.deleteClientById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Client updateClient(@RequestBody Client client, @PathVariable Long id) {
        return clientServiceImpl.updateClientById(id, client);
    }
}
