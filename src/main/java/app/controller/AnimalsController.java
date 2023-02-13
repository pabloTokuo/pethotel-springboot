package app.controller;

import app.dto.UpdateStatusDTO;
import app.model.Animals;
import app.model.enums.StatusPet;
import app.services.impl.AnimalsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pethotel/pet")
public class AnimalsController {

    @Autowired
    private AnimalsServiceImpl animalsService;

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
    public Animals insertOwner(@RequestBody @Valid Animals animals) {
        return animalsService.insertAnimals(animals);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimalById(@PathVariable Long id) {
        animalsService.deleteAnimalById(id);
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
