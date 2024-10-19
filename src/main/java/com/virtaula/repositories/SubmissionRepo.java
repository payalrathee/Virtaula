package com.virtaula.repositories;

import com.virtaula.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission, Integer> {
}
