package com.virtaula.Services;

import com.virtaula.entities.Assignment;
import com.virtaula.entities.Course;
import com.virtaula.entities.StudyMaterial;
import com.virtaula.repositories.AssignmentRepo;
import com.virtaula.repositories.StudyMaterialRepo;
import com.virtaula.repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;
    @Autowired
    StudyMaterialRepo studyMaterialRepo;
    @Autowired
    AssignmentRepo assignmentRepo;

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

    public Course getCourse(int id) {
        return courseRepo.findById(id).get();
    }
    public List<StudyMaterial> getStudyMaterialList(int courseId)
    {
        return courseRepo.findById(courseId).get().getMaterial();
    }
    public List<Assignment> getAssignmentList(int courseId)
    {
        return courseRepo.findById(courseId).get().getAssignments();
    }
    public StudyMaterial getStudyMaterial(int id)
    {
        return studyMaterialRepo.findById(id).get();
    }
    public Assignment getAssignment(int id)
    {
        return assignmentRepo.findById(id).get();
    }
    public void deleteAssignment(int id)
    {
        assignmentRepo.deleteById(id);
    }
    public void deleteStudyMaterial(int id)
    {
        studyMaterialRepo.deleteById(id);
    }
    public void deleteCourse(int id)
    {
        courseRepo.deleteById(id);
    }
}
