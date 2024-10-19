package com.virtaula.repositories;

import com.virtaula.users.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    public Student findByEmailAndPassword(String email, String password);
}
