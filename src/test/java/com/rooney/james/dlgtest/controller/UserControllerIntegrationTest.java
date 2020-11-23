package com.rooney.james.dlgtest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rooney.james.dlgtest.DlgTestApplication;
import com.rooney.james.dlgtest.domain.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DlgTestApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("devmock")
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getUserThatDoesNotExist() throws Exception {
        mockMvc.perform(get("/users").param("email", "james33@test.com"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getUserByEmail() throws Exception {
        mockMvc.perform(get("/users").param("email", "james2@test.com")) //.accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("f_name2"))
                .andExpect(jsonPath("$.lastName").value("l_name2"))
                .andExpect(jsonPath("$.email").value("james2@test.com"));
    }

    @Test
    void createUser() throws Exception {
        UserDTO newUser = UserDTO.builder()
                .firstName("John")
                .lastName("Wayne")
                .email("johnwayne@test.com")
                .password("password")
                .department("IT")
                .jobTitle("Developer")
                .phoneNumber("123456")
                .build();

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(newUser)))
                .andExpect(status().isCreated());
    }

    @Test
    void createUserWithExistingEmail() throws Exception {
        UserDTO newUser = UserDTO.builder()
                .firstName("John")
                .lastName("Wayne2")
                .email("james3@test.com")
                .password("password")
                .department("IT")
                .jobTitle("Developer")
                .phoneNumber("123457")
                .build();

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(newUser)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidUserMissingLastName() throws Exception {
        UserDTO newUser = UserDTO.builder()
                .firstName("John")
                .email("johnwayne@test.com")
                .build();

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(newUser)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createInvalidUserEmail() throws Exception {
        UserDTO newUser = UserDTO.builder()
                .firstName("John")
                .lastName("Wayne")
                .email("johnwayne")
                .build();

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(newUser)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteUserThatExists() throws Exception {
        mockMvc.perform(delete("/users").param("email", "james1@test.com"))
                .andExpect(status().isOk());
    }

    @Test()
    void deleteUserThatDoesNotExists() throws Exception {
        mockMvc.perform(delete("/users").param("email", "james11@test.com"))
                .andExpect(status().isOk());
    }

    @Test
    void updateUser() throws Exception {
        UserDTO updatedUser = UserDTO.builder()
                .firstName("John")
                .lastName("Wayne")
                .email("james2@test.com")
                .password("password")
                .department("IT")
                .jobTitle("Developer")
                .phoneNumber("123456")
                .build();

        mockMvc.perform(put("/users").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updatedUser)))
                .andExpect(status().isOk());
    }

    @Test
    void updateUserThatDoesNotExist() throws Exception {
        UserDTO updatedUser = UserDTO.builder()
                .firstName("John")
                .lastName("Wayne")
                .email("james330@test.com")
                .password("password")
                .department("IT")
                .jobTitle("Developer")
                .phoneNumber("123456")
                .build();

        mockMvc.perform(put("/users").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updatedUser)))
                .andExpect(status().isNotFound());
    }
}
