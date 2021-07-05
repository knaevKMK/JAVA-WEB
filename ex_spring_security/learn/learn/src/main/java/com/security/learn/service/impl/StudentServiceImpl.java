package com.security.learn.service.impl;

import com.security.learn.models.binding.StudentBindingModel;
import com.security.learn.models.entitie.StudentEntity;
import com.security.learn.models.service.StudentViewModel;
import com.security.learn.repositories.StudentRepository;
import com.security.learn.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public void registrateStudent(StudentBindingModel studentBindingModel) {
        this.studentRepository.save(convertDtoToEntity(studentBindingModel));
    }

    private StudentEntity convertDtoToEntity(StudentBindingModel studentBindingModel) {
        return modelMapper.map(studentBindingModel, StudentEntity.class);
    }

    private StudentViewModel convertEntitytoView(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentViewModel.class);
    }
    @Override
    public StudentViewModel getStudentById(Long id) {
        StudentEntity studentEntity= this.studentRepository.findById(id)
                .orElse(null);
     return   this.convertEntitytoView(studentEntity);

    }
}
