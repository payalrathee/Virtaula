package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.StudentService;
import com.finalsem.cms.users.Admin;
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
        student.setDp("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBKxzxsHLzob3TZu7h3qZBGu7wI8ZKnN8pnA&usqp=CAU\"");
        studentService.saveOrUpdateStudent(student);
        return "redirect:/signinForm";
    }

    @RequestMapping("/profile")
    public String profile(Model model,HttpSession session)
    {
        Student student=studentService.getStudent((Integer) session.getAttribute("id"));
        model.addAttribute("id",student.getStudentId());
        model.addAttribute("name",student.getName());
        model.addAttribute("email",student.getEmail());
        model.addAttribute("phone",student.getPhoneNumber());
        model.addAttribute("password",student.getPassword());
        model.addAttribute("dp",student.getDp());
        return "profile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute Student student,HttpSession session)
    {
        studentService.saveOrUpdateStudent(student);

        session.setAttribute("id",student.getStudentId());
        session.setAttribute("email",student.getEmail());
        session.setAttribute("password",student.getPassword());
        session.setAttribute("accountType","student");
        session.setAttribute("dp",student.getDp());

        return "redirect:/student/profile";
    }
}
