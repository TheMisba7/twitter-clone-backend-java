package org.mansar.twitterjava.api;

import org.mansar.twitterjava.app.UserApp;
import org.mansar.twitterjava.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserApp userApp;

    public UserController(UserApp userApp) {
        this.userApp = userApp;
    }

    @PostMapping()
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userApp.create(userDTO);
    }


    @GetMapping("")
    public UserDTO get() {
        return userApp.get();
    }
}
