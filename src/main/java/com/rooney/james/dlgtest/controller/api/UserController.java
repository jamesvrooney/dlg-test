package com.rooney.james.dlgtest.controller.api;

import com.rooney.james.dlgtest.domain.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

public interface UserController {
    @Operation(summary = "Get a user using their email")
    UserDTO getUser(String userEmail);

    @Operation(summary = "Create a new user")
    ResponseEntity<Void> createUser(UserDTO user);

    @Operation(summary = "Delete an existing user")
    void deleteUser(String userEmail);

    @Operation(summary = "Update an existing user")
    ResponseEntity<Void> updateUser(UserDTO user);
}
