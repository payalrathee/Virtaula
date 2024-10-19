package com.virtaula.repositories;

import com.virtaula.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment,Integer> {
}
