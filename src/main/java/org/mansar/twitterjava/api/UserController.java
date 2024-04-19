package org.mansar.twitterjava.api;

import org.mansar.twitterjava.app.UserApp;
import org.mansar.twitterjava.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserApp userApp;

    public UserController(UserApp userApp) {
        this.userApp = userApp;
    }

    @PostMapping()
    public UserDTO create(UserDTO userDTO) {
        return userApp.create(userDTO);
    }
}
