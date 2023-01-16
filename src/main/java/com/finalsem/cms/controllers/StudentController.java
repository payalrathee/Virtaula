package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.StudentService;
import com.finalsem.cms.users.Student;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/enrollForm")
    public String enrollForm()
    {
        return "enroll";
    }
    // Enroll in any course
    @PostMapping("/enroll")
    public String enroll(@RequestParam("courseId") int courseId,@RequestParam("code") String code,HttpSession session,Model model)
    {
        if(studentService.enroll(courseId,code, (Integer) session.getAttribute("id")))
        return "redirect:/student/courses";
        model.addAttribute("errorMessage","Course id or code is incorrect!");
        return "enroll";
    }
    //add student
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student)
    {
        studentService.saveOrUpdateStudent(student);
        return "redirect:/signinForm";
    }
}
