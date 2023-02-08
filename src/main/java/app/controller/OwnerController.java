package app.controller;

import app.model.Owner;
import app.services.impl.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pethotel")
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerService;

    @GetMapping
    public List<Owner> findAllOwners() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    public Owner findById(@PathVariable Long id) {
        return ownerService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner insertOwner(@RequestBody Owner owner) {
        return ownerService.insertOwner(owner);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOwnerByid(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Owner updateOwner(@RequestBody Owner owner, @PathVariable Long id) {
        return ownerService.updateOwnerById(id, owner);
    }
}
