package com.example.demo.student;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );
    // hasRole('ROLE_')
// hasAnyRole('ROLE_',...)
// hasAuthority('permission')
// hasAnyAuthority('permission')

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    public List<Student> getAllStudents (){
        return STUDENTS;
    }

    @GetMapping(path = "{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    public Student getStudentById (@PathVariable("studentId") Integer studentId){

        return STUDENTS.get(studentId-1);
    }


    @PostMapping
  @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){

        System.out.println("added new student: "+student.getStudentName() );
    }

    @DeleteMapping("{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("delete: " + studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId,
                              @RequestBody Student student){
        System.out.println(studentId + " "+ student.getStudentName() );
    }
}
