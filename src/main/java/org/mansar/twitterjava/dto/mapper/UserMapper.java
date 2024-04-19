package org.mansar.twitterjava.dto.mapper;

import org.mansar.twitterjava.dto.UserDTO;
import org.mansar.twitterjava.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO toDTO(User user);
    User fromDTO(UserDTO userDTO);
}
