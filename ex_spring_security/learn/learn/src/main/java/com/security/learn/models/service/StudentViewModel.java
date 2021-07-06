package com.security.learn.models.service;

import com.security.learn.models.entitie.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class StudentViewModel {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private LocalDate startEducation;
    private String course;
    private String imageUrl;
}
