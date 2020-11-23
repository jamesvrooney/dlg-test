package com.rooney.james.dlgtest.controller;

import com.rooney.james.dlgtest.controller.api.UserController;
import com.rooney.james.dlgtest.domain.UserDTO;
import com.rooney.james.dlgtest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping()
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserDTO user) {
        LOGGER.info("Creating a new user");

        userService.createUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String email) {
        LOGGER.info("Preparing to delete user with email: {}", email);

        userService.deleteUser(email);

        LOGGER.info("User deleted");
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody @Valid UserDTO user) {
        LOGGER.info("Updating an existing user: {}", user.getEmail());

        userService.updateUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
