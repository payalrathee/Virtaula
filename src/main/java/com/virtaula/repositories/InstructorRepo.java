package com.virtaula.repositories;

import com.virtaula.users.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor,Integer> {
    public Instructor findByEmailAndPassword(String email, String password);
}
