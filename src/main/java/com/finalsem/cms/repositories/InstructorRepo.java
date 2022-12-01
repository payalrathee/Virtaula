package com.finalsem.cms.repositories;

import com.finalsem.cms.users.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor,Integer> {
}
