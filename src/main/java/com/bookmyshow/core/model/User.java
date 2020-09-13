package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Auditable {
    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    @Setter
    Set<Role> roles = new HashSet<>();
    @Email
    @NotBlank
    @Column(unique = true)
    @Getter
    @Setter
    private String email;
    @NotBlank
    @Getter
    private String saltedHashedPassword;

    public User() {
    }

    public User(User user) { // copy constructor
        email = user.getEmail();
        saltedHashedPassword = user.getSaltedHashedPassword();
        roles = user.getRoles();
    }

    public void setSaltedHashedPassword(String value) {
        this.saltedHashedPassword = new BCryptPasswordEncoder(5).encode(value);
    }
}
