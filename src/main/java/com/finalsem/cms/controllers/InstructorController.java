package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.CourseService;
import com.finalsem.cms.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    CourseService courseService;

    // Get all courses
    @GetMapping("/courses/{id}")
    private ResponseEntity<List<Course>> getCourses(@PathVariable("id") int id){
        try{
            return new ResponseEntity<>(courseService.getCoursesByInstructor(id), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   // private List<Courses>
    // CRUD assignment
    // Get list all student
}
