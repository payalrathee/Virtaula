package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/courseDetails/{courseId}")
    public String courseDetails(@PathVariable("courseId") int courseId, Model model)
    {
        System.out.println(courseId);
        model.addAttribute("course",courseService.getCourse(courseId));
        return "course";
    }

    @GetMapping("/studyMaterial/{courseId}")
    public String studyMaterial(@PathVariable("courseId") int courseId, Model model)
    {
        model.addAttribute("studyMaterialList",courseService.getStudyMaterialList(courseId));
        model.addAttribute("courseId",courseId);
        return "studyMaterialList";
    }

    @GetMapping("/studyMaterialDetails/{id}")
    public String studyMaterialDetails(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("studyMaterial",courseService.getStudyMaterial(id));
        return "studyMaterial";
    }

    @GetMapping("/assignments/{courseId}")
    public String assignments(@PathVariable("courseId") int courseId, Model model)
    {
        model.addAttribute("assignmentList",courseService.getAssignmentList(courseId));
        model.addAttribute("courseId",courseId);
        return "assignmentList";
    }

    @GetMapping("/assignmentDetails/{id}")
    public String assignmentDetails(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("assignment",courseService.getAssignment(id));
        return "assignment";
    }
}
