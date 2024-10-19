package com.virtaula.repositories;

import com.virtaula.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
    public Admin findByEmailAndPassword(String email, String password);
}
