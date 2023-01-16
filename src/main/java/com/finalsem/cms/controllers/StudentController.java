package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.StudentService;
import com.finalsem.cms.users.Student;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    // Get list of all courses
    @RequestMapping("/courses")
    public String courses(Model model, HttpSession session)
    {
        model.addAttribute("courseList",studentService.getCourses((Integer) session.getAttribute("id")));
        return "allCourses";
    }

    // Enroll in any course
    //add student
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student)
    {
        studentService.saveOrUpdateStudent(student);
        return "redirect:/signinForm";
    }
}
