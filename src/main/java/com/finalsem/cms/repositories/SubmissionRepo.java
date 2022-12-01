package com.finalsem.cms.repositories;

import com.finalsem.cms.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission, Integer> {
}
