package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.CourseService;
import com.finalsem.cms.Services.InstructorService;
import com.finalsem.cms.entities.Course;
import com.finalsem.cms.users.Admin;
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

    @RequestMapping("/courses")
    public String courses(Model model, HttpSession session)
    {
        model.addAttribute("courseList",instructorService.getCourse((Integer) session.getAttribute("id")));
        return "allCourses";
    }

    @PostMapping("/addInstructor")
    public String addInstructor(@ModelAttribute Instructor instructor)
    {
        instructor.setDp("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBKxzxsHLzob3TZu7h3qZBGu7wI8ZKnN8pnA&usqp=CAU");
        instructorService.saveOrUpdateInstructor(instructor);
        return "redirect:/signinForm";
    }

    @GetMapping("/addAssignmentForm/{courseId}")
    public String addAssignmentForm(@PathVariable("courseId") int courseId,Model model)
    {
        model.addAttribute("courseId",courseId);
        return "addAssignment";
    }

    @PostMapping("/addAssignment")
    public String addAssignment()
    {
        return "redirect:/course/assignments/";
    }

    @GetMapping("/addStudyMaterialForm/{courseId}")
    public String addStudyMaterialForm(@PathVariable("courseId") int courseId,Model model)
    {
        model.addAttribute("courseId",courseId);
        return "addStudyMaterial";
    }

    @PostMapping("/addStudyMaterial")
    public String addStudyMaterial()
    {
        return "redirect:/course/studyMaterial/";
    }

    @RequestMapping("/updateStudyMaterialForm/{id}")
    public String updateStudyMaterialForm(@PathVariable("id") int id,Model model)
    {
        model.addAttribute("studyMaterial",courseService.getStudyMaterial(id));
        return "updateStudyMaterial";
    }

    @PostMapping("/updateStudyMaterial")
    public String updateStudyMaterial()
    {
        //
        return "redirect:/course/studyMaterialDetails";
    }

    @RequestMapping("/updateAssignmentForm/{id}")
    public String updateAssignmentForm(@PathVariable("id") int id,Model model)
    {
        model.addAttribute("assignment",courseService.getAssignment(id));
        return "updateAssignment";
    }

    @PostMapping("/updateAssignment")
    public String updateAssignment()
    {
        //
        return "redirect:/course/assignmentDetails";
    }

    @RequestMapping("/profile")
    public String profile(Model model,HttpSession session)
    {
        Instructor instructor=instructorService.getInstructor((Integer) session.getAttribute("id"));
        model.addAttribute("id",instructor.getInstructorId());
        model.addAttribute("name",instructor.getName());
        model.addAttribute("email",instructor.getEmail());
        model.addAttribute("phone",instructor.getPhoneNumber());
        model.addAttribute("password",instructor.getPassword());
        model.addAttribute("dp",instructor.getDp());
        return "profile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute Instructor instructor,HttpSession session)
    {
        instructorService.saveOrUpdateInstructor(instructor);

        session.setAttribute("id",instructor.getInstructorId());
        session.setAttribute("email",instructor.getEmail());
        session.setAttribute("password",instructor.getPassword());
        session.setAttribute("accountType","instructor");
        session.setAttribute("dp",instructor.getDp());

        return "redirect:/instructor/profile";
    }
}
