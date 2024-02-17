package com.example.EcommerceMVC.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long Id;
    @NotEmpty(message = "Please Add Firstname")
    private String firstName;
    @NotEmpty(message = "Please Add Lastname")
    private String lastName;
    @NotEmpty(message = "Please Add Email")
    @Email
    private String email;
    @NotEmpty(message = "Please Add Password")
    private String password;
    private boolean registered;

}
