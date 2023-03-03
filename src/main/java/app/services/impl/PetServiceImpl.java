package app.services.impl;

import app.exception.BusinessRuleException;
import app.model.Pet;
import app.model.enums.StatusPet;
import app.repositories.ClientRepository;
import app.repositories.PetRepository;
import app.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findPetById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal not found"));
    }

    @Override
    public Pet insertPet(Pet pet) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        pet.setCheckInDate(LocalDate.now());
        pet.setCheckInTime(LocalTime.parse(sdf.format(date)));
        pet.setClient(clientRepository.findById(pet.getClient().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return petRepository.save(pet);
    }

    @Override
    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public void updateStatus(Long id, StatusPet statusPet) {
        petRepository.findById(id).map(animals -> {
            animals.setStatusPet(statusPet);
            animals.setCheckOutDate(LocalDate.now());
            animals.setCheckOutTime(LocalTime.now());
            return petRepository.save(animals);
        }).orElseThrow(() -> new BusinessRuleException("Pet ID not found."));
    }
}
