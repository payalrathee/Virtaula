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
        if(accountType.equals("student"))
        {
            Student s=studentService.validateStudent(email, password);
            if (s != null) {
                session.setAttribute("id",s.getStudentId());
                session.setAttribute("email",s.getEmail());
                session.setAttribute("password",s.getPassword());
                session.setAttribute("accountType","student");
                session.setAttribute("dp",s.getDp());
                return "index";
            }
        } else if (accountType.equals("instructor"))
        {
            Instructor i=instructorService.validateInstructor(email, password);
            if (i != null) {
                session.setAttribute("id",i.getInstructorId());
                session.setAttribute("email",i.getEmail());
                session.setAttribute("password",i.getPassword());
                session.setAttribute("accountType","instructor");
                session.setAttribute("dp",i.getDp());
                return "index";
            }
        }
        else
        {
            Admin a=adminService.validateAdmin(email, password);
            if (a != null) {
                session.setAttribute("id",a.getAdminId());
                session.setAttribute("email",a.getEmail());
                session.setAttribute("password",a.getPassword());
                session.setAttribute("accountType","admin");
                session.setAttribute("dp",a.getDp());
                return "index";
            }
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

