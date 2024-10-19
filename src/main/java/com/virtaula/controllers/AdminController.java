package com.virtaula.controllers;

import com.virtaula.Services.AdminService;
import com.virtaula.Services.CourseService;
import com.virtaula.Services.StudentService;
import com.virtaula.entities.Course;
import com.virtaula.users.Admin;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        admin.setDp("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBKxzxsHLzob3TZu7h3qZBGu7wI8ZKnN8pnA&usqp=CAU");
        adminService.saveOrUpdateAdmin(admin);
        return "redirect:/signinForm";
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
    public String addCourse(@ModelAttribute Course course)
    {
        courseService.saveOrUpdate(course);
        return "redirect:/admin/courses";
    }

    @RequestMapping("/updateCourseForm/{id}")
    public String updateCourseForm(@PathVariable("id") int id,Model model)
    {
        model.addAttribute("course",courseService.getCourse(id));
        return "updateCourse";
    }

    @PostMapping("/updateCourse")
    public String updateCourse()
    {
        //
        return "redirect:/course/courseDetails";
    }
    @RequestMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable("id") int id)
    {
        courseService.deleteCourse(id);
        return "redirect:/admin/courses";
    }

    @RequestMapping("/profile")
    public String profile(Model model,HttpSession session)
    {
        Admin admin=adminService.getAdmin((Integer) session.getAttribute("id"));
        model.addAttribute("id",admin.getAdminId());
        model.addAttribute("name",admin.getName());
        model.addAttribute("email",admin.getEmail());
        model.addAttribute("phone",admin.getPhoneNumber());
        model.addAttribute("password",admin.getPassword());
        model.addAttribute("dp",admin.getDp());
        return "profile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute Admin admin,HttpSession session)
    {
        adminService.saveOrUpdateAdmin(admin);

        session.setAttribute("id",admin.getAdminId());
        session.setAttribute("email",admin.getEmail());
        session.setAttribute("password",admin.getPassword());
        session.setAttribute("accountType","admin");
        session.setAttribute("dp",admin.getDp());

        return "redirect:/admin/profile";
    }
}

