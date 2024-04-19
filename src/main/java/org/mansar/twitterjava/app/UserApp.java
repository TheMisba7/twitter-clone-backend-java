package org.mansar.twitterjava.app;

import org.mansar.twitterjava.dao.UserDao;
import org.mansar.twitterjava.dto.UserDTO;
import org.mansar.twitterjava.dto.mapper.UserMapper;
import org.mansar.twitterjava.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserApp extends AbstractApp<User, UserDao> {
    private final UserMapper userMapper;
    public UserApp(UserDao dao, UserMapper userMapper) {
        super(dao);
        this.userMapper = userMapper;
    }

    public UserDTO create(UserDTO userDTO) {
        User saved = super.save(userMapper.fromDTO(userDTO));
        return userMapper.toDTO(saved);
    }
}
