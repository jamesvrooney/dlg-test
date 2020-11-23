package com.rooney.james.dlgtest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String department;

    @NotEmpty
    private String jobTitle;
}

