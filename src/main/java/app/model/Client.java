package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty
    private String name;

    @Column
    private String email;

    @Column
    @NotEmpty
    private String phone;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Animals> animals;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Address> address;
}