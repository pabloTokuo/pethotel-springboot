package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "{field.name.mandatory}")
    private String name;

    @Column
    private String email;

    @Column
    @NotEmpty(message = "{field.email.mandatory}")
    private String phone;

    @Column(length = 11)
    @CPF(message = "{field.cpf.invalid}")
    @NotEmpty(message = "{field.cpf.mandatory}")
    private String cpf;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Set<Pet> animals;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Set<Address> address;
}