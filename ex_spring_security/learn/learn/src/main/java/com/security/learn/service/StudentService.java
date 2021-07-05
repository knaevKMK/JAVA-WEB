package com.security.learn.service;

import com.security.learn.models.service.StudentViewModel;

public interface StudentService {
    StudentViewModel getStudentById(Long id);
}
