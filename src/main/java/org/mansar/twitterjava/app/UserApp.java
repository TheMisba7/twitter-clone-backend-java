package org.mansar.twitterjava.app;

import org.mansar.twitterjava.dao.UserDao;
import org.mansar.twitterjava.dto.UserDTO;
import org.mansar.twitterjava.dto.mapper.UserMapper;
import org.mansar.twitterjava.model.Role;
import org.mansar.twitterjava.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserApp extends AbstractApp<User, UserDao> {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    public UserApp(UserDao dao, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        super(dao);
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO create(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userMapper.fromDTO(userDTO);
        user.setRoles(Set.of(Role.USER));
        User saved = super.save(user);
        return userMapper.toDTO(saved);
    }
}
