package app.services;

import app.model.Pet;
import app.model.enums.StatusPet;

import java.util.List;

public interface PetService {

    List<Pet> findAll();

    Pet findPetById(Long id);

    Pet insertPet(Pet pet);

    void deletePetById(Long id);

    void updateStatus(Long id, StatusPet statusPet);

}
