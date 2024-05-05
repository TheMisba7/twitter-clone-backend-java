package org.mansar.twitterjava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mansar.twitterjava.model.Role;
import org.mansar.twitterjava.model.Tweet;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class UserDTO {
    private Long Id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String country;
    private String email;
    private String password;
    private Collection<Role> roles;
}
