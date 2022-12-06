package com.finalsem.cms.Services;

import com.finalsem.cms.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import com.finalsem.cms.repositories.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceIml implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public List<Course> getCourses() {
        List<Course> list = courseRepo.findAll();
        return list;
    }

}
