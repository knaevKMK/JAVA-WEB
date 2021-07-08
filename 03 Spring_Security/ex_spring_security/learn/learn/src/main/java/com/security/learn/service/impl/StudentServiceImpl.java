package com.security.learn.service.impl;

import com.security.learn.models.binding.StudentBindingModel;
import com.security.learn.models.entitie.StudentEntity;
import com.security.learn.models.service.StudentViewModel;
import com.security.learn.repositories.StudentRepository;
import com.security.learn.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public void registrateStudent(StudentEntity studentEntity) {
        this.studentRepository.save(studentEntity);
    }

    @Override
    public Optional<StudentEntity> getStudentById(Long id) {
       return this.studentRepository.findById(id);


    }

    @Override
    public Set<StudentEntity> getAllStudents() {
        return this.studentRepository
                .findAll()
                .stream().limit(10)
                .collect(Collectors.toSet());
    }
}
