package com.exam2.exam2.model.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserRegisterBindingModel {
    @NotNull(message = "Username can not be null")
    @Size(min=3, max = 20,message = "Username length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String username;

    @NotNull(message = "Email is not valid")
    @NotBlank(message = "Email can not be empty")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Password can not be empty")
    @Size(min = 3, max = 20,message = "Password length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String password;


    private String confirmPassword;
}
