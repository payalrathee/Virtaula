package com.finalsem.cms.Services;

import com.finalsem.cms.entities.Course;
import com.finalsem.cms.users.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.finalsem.cms.repositories.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public Student getStudent(int id) {
        return studentRepo.findById(id).get();
    }

    public void saveOrUpdateStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }
    public List<Course> getCourses(int id)
    {
        return studentRepo.findById(id).get().getCourses();
    }

    public int validateStudent(String email,String password)
    {
        Student s=studentRepo.findByEmailAndPassword(email,password);
        if(s!=null)
            return s.getStudentId();
        return -1;
    }
}
