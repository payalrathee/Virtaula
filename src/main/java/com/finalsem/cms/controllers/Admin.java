package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.StudentService;
import com.finalsem.cms.users.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class Admin {
    @Autowired
    StudentService studentService;

    // Get list of students
    @GetMapping("/home/students")
    public List<Student> addStudent(){
        return studentService.getStudents();
    }
    // Update student
    // Add new student
    // Delete student
    // Modify
}

