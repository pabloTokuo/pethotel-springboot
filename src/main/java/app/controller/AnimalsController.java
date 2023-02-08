package app.controller;

import app.model.Animals;
import app.services.impl.AnimalsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
