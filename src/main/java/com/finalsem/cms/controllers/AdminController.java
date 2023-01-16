package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.AdminService;
import com.finalsem.cms.Services.CourseService;
import com.finalsem.cms.Services.StudentService;
import com.finalsem.cms.entities.Course;
import com.finalsem.cms.users.Admin;
import com.finalsem.cms.users.Instructor;
import com.finalsem.cms.users.Student;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    AdminService adminService;

    @PostMapping("/addAdmin")
    public String addAdmin(@ModelAttribute Admin admin)
    {
        adminService.saveOrUpdateAdmin(admin);
        return "redirect:/signinForm";
    }

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
            studentService.saveOrUpdateStudent(student);
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
            studentService.saveOrUpdateStudent(student);
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
            Course course = courseService.getCourse(id);
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/courses")
    public String courses(Model model)
    {
        model.addAttribute("courseList",courseService.getCourses());
        return "allCourses";
    }

    @RequestMapping("/addCourseForm")
    public String addCourseForm()
    {
        return "addCourse";
    }

    @PostMapping("/addCourse")
    public String addCourse()
    {
        //
        return "redirect:/admin/courses";
    }
}

