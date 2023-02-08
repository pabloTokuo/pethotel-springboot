package app.repositories;

import app.model.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {
}
