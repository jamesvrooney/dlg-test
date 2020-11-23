package com.rooney.james.dlgtest.controller.mapper;

import com.rooney.james.dlgtest.domain.User;
import com.rooney.james.dlgtest.domain.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDto(User user);
    User userDtoToUser(UserDTO userDTO);
}