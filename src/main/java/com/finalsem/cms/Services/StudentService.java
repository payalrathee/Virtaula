package com.finalsem.cms.Services;

import com.finalsem.cms.users.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finalsem.cms.repositories.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }
}
