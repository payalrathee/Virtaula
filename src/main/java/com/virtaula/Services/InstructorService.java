package com.virtaula.Services;

import com.virtaula.entities.Course;
import com.virtaula.repositories.InstructorRepo;
import com.virtaula.users.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorService {
    @Autowired
    InstructorRepo instructorRepo;

    public List<Instructor> getInstructors(){
        return instructorRepo.findAll();
    }

    public Instructor getInstructor(int id) {
        return instructorRepo.findById(id).get();
    }

    public void saveOrUpdateInstructor(Instructor instructor) {
        instructorRepo.save(instructor);
    }

    public void deleteInstructor(int id) {
        instructorRepo.deleteById(id);
    }
    public List<Course> getCourse(int id)
    {
        return instructorRepo.findById(id).get().getCourses();
    }

    public Instructor validateInstructor(String email,String password)
    {
        return instructorRepo.findByEmailAndPassword(email, password);
    }
}
