package app.services.impl;

import app.model.Animals;
import app.repositories.AnimalsRepository;
import app.repositories.OwnerRepository;
import app.services.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimalsServiceImpl implements AnimalsService {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Animals> findAll() {
        return animalsRepository.findAll();
    }

    @Override
    public Animals findAnimalById(Long id) {
        return animalsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal not found"));
    }

    @Override
    public Animals insertAnimals(Animals animals) {
        return animalsRepository.save(animals);
    }
}
