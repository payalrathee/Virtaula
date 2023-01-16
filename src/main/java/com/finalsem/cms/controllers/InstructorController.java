package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.CourseService;
import com.finalsem.cms.Services.InstructorService;
import com.finalsem.cms.entities.Course;
import com.finalsem.cms.users.Instructor;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    CourseService courseService;
    @Autowired
    InstructorService instructorService;

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
    @RequestMapping("/courses")
    public String courses(Model model, HttpSession session)
    {
        model.addAttribute("courseList",instructorService.getCourse((Integer) session.getAttribute("id")));
        return "allCourses";
    }

    // CRUD assignment
    // Get list all student

    @PostMapping("/addInstructor")
    public String addInstructor(@ModelAttribute Instructor instructor)
    {
        instructorService.saveOrUpdateInstructor(instructor);
        return "redirect:/signinForm";
    }
}
