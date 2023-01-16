package com.finalsem.cms.Services;

import com.finalsem.cms.entities.Course;
import com.finalsem.cms.repositories.InstructorRepo;
import com.finalsem.cms.users.Instructor;
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

    public int validateInstructor(String email,String password)
    {
        Instructor i=instructorRepo.findByEmailAndPassword(email, password);
        if(i!=null)
            return i.getInstructorId();
        return -1;
    }
}
