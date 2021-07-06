package com.security.learn.api;


import com.security.learn.models.binding.StudentBindingModel;
import com.security.learn.models.entitie.StudentEntity;
import com.security.learn.models.service.StudentViewModel;
import com.security.learn.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;

    private StudentEntity convertDtoToEntity(StudentBindingModel studentBindingModel) {
        return modelMapper.map(studentBindingModel, StudentEntity.class);
    }

    private StudentViewModel convertEntityToView(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentViewModel.class);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('STUDENT_READ')")
    public String getStudentById(Model model,
                                 @PathVariable Long id) {
        Optional<StudentEntity> studentEntity = this.studentService.getStudentById(id);
        if (studentEntity.isEmpty()) {
            return "pageNotFound";
        }
        model.addAttribute("student", convertEntityToView(studentEntity.get()));

        return "studentDetails";
    }

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", this.studentService.getAllStudents());

        return "studentCatalog";
    }
}
