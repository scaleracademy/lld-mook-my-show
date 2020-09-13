package com.bookmyshow.core.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User extends Auditable {
    @Column(unique = true)
    @Getter @Setter
    private String email;
    private String saltedHashedPassword;

    @ManyToMany
    private List<Role> roles = new ArrayList<>();

    @OneToOne
    private Profile profile;
}

// Store the password directly?
// people reuse passwords
// Sameer uses the password xyz on Scaler.com and has email id sameer@gmail.com
// Richard => uses his girlfriends name as the password

// Hash the password
// Hash(something) => hashcode
// one way function
// MD5 is a big nono. 5 years back md5 was cracked.
// SHA256/ SHA512
// base64 x big nono because base64 is an encoding

/*

Username  hashedPassword
ashish    ksjdhfisdf
Ranjeet   pwojrpewior
Vivek     ksjdhfisdf

commonpasswords.txt => hash all of them => 80% user password

// Salt => some random value based on username that is added to the password before hashing


 */