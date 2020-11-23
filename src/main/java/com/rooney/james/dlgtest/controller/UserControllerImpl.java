package com.rooney.james.dlgtest.controller;

import com.rooney.james.dlgtest.controller.api.UserController;
import com.rooney.james.dlgtest.domain.UserDTO;
import com.rooney.james.dlgtest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserControllerImpl implements UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);

    private UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserDTO getUser(@RequestParam String email) {
        LOGGER.info("Getting a user with id: {}", email);

        UserDTO user = userService.getUser(email);

        return user;
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
