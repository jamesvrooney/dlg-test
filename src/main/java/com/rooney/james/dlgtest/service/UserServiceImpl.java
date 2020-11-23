package com.rooney.james.dlgtest.service;

import com.rooney.james.dlgtest.domain.UserDTO;
import com.rooney.james.dlgtest.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void createUser(UserDTO newUser) {

    }

    @Override
    public UserDTO getUser(String email) throws UserNotFoundException {
        UserDTO dummyUser = UserDTO.builder()
                .firstName("james")
                .lastName("rooney")
                .email("james@test.com")
                .phoneNumber("12345")
                .department("IT")
                .jobTitle("Developer")
                .password("password")
                .build();

        return dummyUser;
    }

    @Override
    public void updateUser(UserDTO updatedUser) throws UserNotFoundException {

    }

    @Override
    public void deleteUser(String email) {

    }
}
