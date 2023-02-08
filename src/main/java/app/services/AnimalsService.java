package app.services;

import app.model.Animals;

import java.util.List;

public interface AnimalsService {

    List<Animals> findAll();

    Animals findAnimalById(Long id);
}
