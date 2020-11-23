package com.rooney.james.dlgtest.controller;

import com.rooney.james.dlgtest.controller.api.UserController;
import com.rooney.james.dlgtest.domain.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserControllerImpl implements UserController {

    @Override
    @GetMapping
    public UserDTO getUser(String userEmail) {
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
    @PostMapping
    public ResponseEntity<Void> createUser(UserDTO user) {
        return null;
    }

    @Override
    @DeleteMapping
    public void deleteUser(String userEmail) {

    }

    @Override
    @PutMapping
    public ResponseEntity<Void> updateUser(UserDTO user) {
        return null;
    }
}
