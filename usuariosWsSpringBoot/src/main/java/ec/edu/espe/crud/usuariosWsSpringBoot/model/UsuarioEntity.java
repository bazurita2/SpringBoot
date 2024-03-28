package ec.edu.espe.crud.usuariosWsSpringBoot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user" , schema = "userdb" , uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="address")
    private String address;

    public UsuarioEntity(String id, String name, String lastName, String email, String password, String address) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
    }
    public UsuarioEntity() {

    }
}
