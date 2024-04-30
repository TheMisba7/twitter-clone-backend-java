package org.mansar.twitterjava.app;

import org.mansar.twitterjava.dao.RoleDao;
import org.mansar.twitterjava.dao.UserDao;
import org.mansar.twitterjava.dto.UserDTO;
import org.mansar.twitterjava.dto.mapper.UserMapper;
import org.mansar.twitterjava.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApp extends AbstractApp<User, UserDao> {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleDao roleDao;
    public UserApp(UserDao dao, UserMapper userMapper,
                   PasswordEncoder passwordEncoder, RoleDao roleDao) {
        super(dao);
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleDao = roleDao;
    }

    public UserDTO create(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userMapper.fromDTO(userDTO);
        user.setRoles(List.of(roleDao.findByName("ADMIN")));
        User saved = super.save(user);
        return userMapper.toDTO(saved);
    }
}
