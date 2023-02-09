package app.controller;

import app.model.Animals;
import app.repositories.OwnerRepository;
import app.services.impl.AnimalsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pethotel/pet")
public class AnimalsController {

    @Autowired
    private AnimalsServiceImpl animalsService;

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Animals> findAll() {
        return animalsService.findAll();
    }

    @GetMapping("/{id}")
    public Animals findById(@PathVariable Long id) {
        return animalsService.findAnimalById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animals insertOwner(@RequestBody Animals animals) {
        animals.setOwner(ownerRepository.findById(animals.getOwner().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return animalsService.insertAnimals(animals);
    }

}
