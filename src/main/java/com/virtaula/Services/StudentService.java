package com.virtaula.Services;

import com.virtaula.entities.Course;
import com.virtaula.repositories.CourseRepo;
import com.virtaula.users.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtaula.repositories.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;

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

    public Student validateStudent(String email,String password)
    {
        return studentRepo.findByEmailAndPassword(email, password);
    }
    public boolean enroll(int courseId, String code, int studentId)
    {
        Course course=courseRepo.findByCourseIdAndCode(courseId,code);
        if(course!=null)
        {
            Student student=studentRepo.findById(studentId).get();
            student.getCourses().add(course);
            studentRepo.save(student);
            course.getStudents().add(student);
            courseRepo.save(course);
            return true;
        }
        return false;
    }
}
