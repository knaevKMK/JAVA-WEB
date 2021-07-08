package com.security.learn.service;

import com.security.learn.models.binding.StudentBindingModel;
import com.security.learn.models.entitie.StudentEntity;
import com.security.learn.models.service.StudentViewModel;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Set;

public interface StudentService {
    Optional<StudentEntity> getStudentById(Long id);

    Set<StudentEntity> getAllStudents();
    void registrateStudent(StudentEntity studentEntity);
}
