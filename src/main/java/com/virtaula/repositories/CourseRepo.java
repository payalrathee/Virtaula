package com.virtaula.repositories;

import com.virtaula.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {
    public Course findByCourseIdAndCode(int courseId,String code);
}
