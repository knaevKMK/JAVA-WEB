package com.security.learn.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class StudentViewModel {
    private long id;
    private String first_name;
    private String last_name;
    private LocalDate dateOfBirth;
}
