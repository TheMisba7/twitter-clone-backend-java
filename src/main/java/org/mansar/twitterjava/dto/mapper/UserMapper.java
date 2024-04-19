package org.mansar.twitterjava.dto.mapper;

import org.mansar.twitterjava.dto.UserDTO;
import org.mansar.twitterjava.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDTO toDTO(User user);
    User fromDTO(UserDTO userDTO);
}
