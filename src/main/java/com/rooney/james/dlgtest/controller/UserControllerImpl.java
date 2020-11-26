package com.rooney.james.dlgtest.controller;

import com.rooney.james.dlgtest.controller.api.UserController;
import com.rooney.james.dlgtest.domain.UserDTO;
import com.rooney.james.dlgtest.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @GetMapping
    public UserDTO getUser(@RequestParam String email) {
        log.info("Getting a user with id: {}", email);

        UserDTO user = userService.getUser(email);

        return user;
    }

    @PostMapping()
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserDTO user) {
        log.info("Creating a new user");

        userService.createUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String email) {
        log.info("Preparing to delete user with email: {}", email);

        userService.deleteUser(email);

        log.info("User deleted");
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody @Valid UserDTO user) {
        log.info("Updating an existing user: {}", user.getEmail());

        userService.updateUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
