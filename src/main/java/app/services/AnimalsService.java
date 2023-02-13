package app.services;

import app.model.Animals;
import app.model.enums.StatusPet;

import java.util.List;

public interface AnimalsService {

    List<Animals> findAll();

    Animals findAnimalById(Long id);

    Animals insertAnimals(Animals animals);

    void deleteAnimalById(Long id);

    void updateStatus(Long id, StatusPet statusPet);

}
