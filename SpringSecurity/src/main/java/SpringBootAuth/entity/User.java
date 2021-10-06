package SpringBootAuth.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Defining an entity for the Users
 */
@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 5)
    @Column(name = "password")
    private String password;

}
