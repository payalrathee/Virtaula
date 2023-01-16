package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.AdminService;
import com.finalsem.cms.Services.CourseService;
import com.finalsem.cms.Services.InstructorService;
import com.finalsem.cms.Services.StudentService;
import com.finalsem.cms.entities.Course;
import com.finalsem.cms.users.Admin;
import com.finalsem.cms.users.Instructor;
import com.finalsem.cms.users.Student;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    InstructorService instructorService;
    @Autowired
    AdminService adminService;

    @RequestMapping("/signinForm")
    public String signinForm() {
        return "signin";
    }
    @PostMapping("/signin")
    public String signin(Model model,@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("accountType") String accountType, HttpSession session)
    {
        int id=-1;
        if(accountType.equals("student"))
            id= studentService.validateStudent(email, password);
        else if(accountType.equals("instructor"))
            id=instructorService.validateInstructor(email, password);
        else
            id=adminService.validateAdmin(email, password);

        if(id!=-1)
        {
            session.setAttribute("email",email);
            session.setAttribute("password",password);
            session.setAttribute("accountType",accountType);
            session.setAttribute("id",id);
            return "index";
        }

        model.addAttribute("errorMessage","Email or password is incorrect");
        return "signin";
    }
    @RequestMapping("/signupType")
    public String signupType() {
        return "signupType";
    }
    @RequestMapping("/studentSignupForm")
    public String studentSignupForm() {
        return "studentSignup";
    }
    @RequestMapping("/instructorSignupForm")
    public String instructorSignupForm() {
        return "instructorSignup";
    }
    @RequestMapping("/adminSignupForm")
    public String adminSignupForm() {
        return "adminSignup";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "signin";
    }

    @RequestMapping("/about")
    public String about()
    {
        return "index";
    }
}

