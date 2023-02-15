package app.model;

import app.model.enums.StatusPet;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "{field.name.mandatory}")
    private String name;

    @Column
    private Integer age;

    @Column(name = "breed", length = 50)
    @NotEmpty(message = "{field.breed.mandatory}")
    private String breed;

    @Column(name = "check_in")
    private LocalDate checkInDate;

    @Column(name = "checkInTime")
    private LocalTime checkInTime;

    @Column(name = "check_out")
    private LocalDate checkOutDate;

    @Column(name = "checkOutTime")
    private LocalTime checkOutTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pet")
    private StatusPet statusPet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
}
