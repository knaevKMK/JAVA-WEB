package com.security.learn.api;


import com.security.learn.models.entitie.StudentEntity;
import com.security.learn.models.service.StudentViewModel;
import com.security.learn.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public String getStudentById(Model model,
                                 @PathVariable Long id){
        StudentViewModel studentViewModel= this.studentService.getStudentById(id);

        return "studentDetails";
    }
}
