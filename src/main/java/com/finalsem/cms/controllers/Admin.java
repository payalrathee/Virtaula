package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.CourseService;
import com.finalsem.cms.Services.StudentService;
import com.finalsem.cms.entities.Course;
import com.finalsem.cms.users.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/admin")
public class Admin {
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    // Get list of students
    @GetMapping("/students")
    private List<Student> addStudent(){
        return studentService.getStudents();
    }

    // Get student
    @GetMapping("/students/{id}")
    private ResponseEntity<Student> updateStudent(@PathVariable("id") int id){
        try{
            return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update student
    @PutMapping("/students/{id}")
    private ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        try{
            studentService.saveOrUpdate(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add new student
    @PostMapping("/students")
    private ResponseEntity<Student> updateStudent(@RequestBody Student student){
        try{
            studentService.saveOrUpdate(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete student
    @DeleteMapping("/students/{id}")
    private void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }

    // Create new course
    @PostMapping("/courses")
    private ResponseEntity<Course> addCourse(@RequestBody Course course){
        try{
            courseService.saveOrUpdate(course);
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Get a particular course
    @GetMapping("/courses/{id}")
    private ResponseEntity<Course> addCourse(@PathVariable("id") int id){
        try{
            Course course = courseService.getById(id);
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

