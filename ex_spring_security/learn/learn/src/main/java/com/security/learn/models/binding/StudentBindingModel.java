package com.security.learn.models.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentBindingModel {
    private String first_name;
    private String last_name;
    private LocalDate dateOfBirth;
}
