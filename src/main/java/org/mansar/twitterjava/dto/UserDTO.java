package org.mansar.twitterjava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mansar.twitterjava.model.Role;
import org.mansar.twitterjava.model.Tweet;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    private List<Tweet> tweets;
    private Set<Role> roles;
}
