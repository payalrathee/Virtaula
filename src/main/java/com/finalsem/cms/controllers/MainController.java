package com.finalsem.cms.controllers;

import com.finalsem.cms.Services.CourseService;
import com.finalsem.cms.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    CourseService courseService;
    @RequestMapping("/home")
    public String welcome(Model model) {
        model.addAttribute("text", "Enter details");
        return "welcome";
    }

    @GetMapping("/home/courses")
    public String getCourses(Model model){
        List<Course> courseList = courseService.getCourses();
        model.addAttribute("list", courseList);
        return "coursesList";
    }

}

