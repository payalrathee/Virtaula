package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.CourseService;
import com.finalsem.cms.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    CourseService courseService;
    @GetMapping("/home")
    public String home() {
        return "Welcome to home page";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

}

