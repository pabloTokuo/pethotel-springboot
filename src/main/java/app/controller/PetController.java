package app.controller;

import app.dto.UpdateStatusDTO;
import app.model.Pet;
import app.model.enums.StatusPet;
import app.services.impl.PetServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pethotel/pet")
public class PetController {

    @Autowired
    private PetServiceImpl animalsService;

    @GetMapping
    public List<Pet> findAll() {
        return animalsService.findAll();
    }

    @GetMapping("/{id}")
    public Pet findById(@PathVariable Long id) {
        return animalsService.findPetById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet insertOwner(@RequestBody @Valid Pet pet) {
        return animalsService.insertPet(pet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimalById(@PathVariable Long id) {
        animalsService.deletePetById(id);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Long id, @RequestBody UpdateStatusDTO updateStatusDTO) {
        String newStatus = updateStatusDTO.getNewStatus();
        LocalDate date = updateStatusDTO.getCheckOutDate();
        LocalDateTime time = updateStatusDTO.getCheckOutTime();
        animalsService.updateStatus(id, StatusPet.valueOf(newStatus));
    }
}
