package com.security.learn.security;

public enum ApplicationUserPermission {
    STUDENT_READ("student_read"),
    STUDENT_WRITE ("student_write"),
    TEACHER_READ("teacher_read"),
    TEACHER_WRITE("teacher_write"),
    COURSE_READ ("course_read"),
    COURSE_WRITE("course_write"),
    DIRECTOR_READ("director_read"),
    DIRECTOR_WRITE("director_write");

    private String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
