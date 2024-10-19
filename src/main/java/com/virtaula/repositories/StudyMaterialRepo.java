package com.virtaula.repositories;

import com.virtaula.entities.StudyMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyMaterialRepo extends JpaRepository<StudyMaterial,Integer> {
}
