package com.rooney.james.dlgtest.controller;

import com.rooney.james.dlgtest.DlgTestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DlgTestApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("devmock")
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getUserByEmail() throws Exception {
        mockMvc.perform(get("/users").param("email", "james2@test.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("f_name2"))
                .andExpect(jsonPath("$.lastName").value("l_name2"))
                .andExpect(jsonPath("$.email").value("james2@test.com"));
    }
}
