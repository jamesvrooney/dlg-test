package com.rooney.james.dlgtest.service;

import com.rooney.james.dlgtest.domain.UserDTO;
import com.rooney.james.dlgtest.exception.UserNotFoundException;

public interface UserService {
    void createUser(UserDTO newUser);
    UserDTO getUser(String email) throws UserNotFoundException;
    void updateUser(UserDTO updatedUser) throws UserNotFoundException;
    void deleteUser(String email);
}
