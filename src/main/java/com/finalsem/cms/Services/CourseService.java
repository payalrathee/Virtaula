package com.finalsem.cms.Services;

import com.finalsem.cms.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import com.finalsem.cms.repositories.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public List<Course> getCourses() {
        List<Course> list = courseRepo.findAll();
        return list;
    }

    public List<Course> getCoursesByInstructor(Integer id) {
        List<Course> list = courseRepo.findAllById(Collections.singleton(id));
        return list;
    }

    public void saveOrUpdate(Course course) {
        courseRepo.save(course);
    }

    public Course getById(int id) {
        return courseRepo.findById(id).get();
    }
}
