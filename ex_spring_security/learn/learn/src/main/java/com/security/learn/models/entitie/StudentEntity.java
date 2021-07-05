package com.security.learn.models.entitie;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter
@Setter
public class StudentEntity extends BaseEntity{

    private String first_name;
    private String last_name;
    private LocalDate dateOfBirth;

}
