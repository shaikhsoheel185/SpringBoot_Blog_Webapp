package com.blog.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationDto {
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Email can't be empty ")
    @Email
    private String email;
    @NotEmpty(message = "Password can't be empty")
    private String password;
}
