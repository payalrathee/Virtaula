package com.virtaula.Services;

import com.virtaula.repositories.AdminRepo;
import com.virtaula.users.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    public List<Admin> getAdmins(){
        return adminRepo.findAll();
    }

    public Admin getAdmin(int id) {
        return adminRepo.findById(id).get();
    }

    public void saveOrUpdateAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    public void deleteAdmin(int id) {
        adminRepo.deleteById(id);
    }

    public Admin validateAdmin(String email,String password)
    {
        return adminRepo.findByEmailAndPassword(email, password);
    }
}
