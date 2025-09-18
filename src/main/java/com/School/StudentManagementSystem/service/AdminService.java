package com.School.StudentManagementSystem.service;

import com.School.StudentManagementSystem.dao.AdminRepository;
import com.School.StudentManagementSystem.entity.Admin;
import com.School.StudentManagementSystem.entity.Student;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public Admin findByEmail(String email) {
        Optional<Admin> adminOptional = adminRepository.findByEmail(email);
        if (adminOptional.isPresent()) {
            return adminOptional.get();
        }
        throw new EntityNotFoundException("Admin not found");
    }

    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }

    public Admin update(Admin admin){
        return adminRepository.save(admin);
    }

    public void delete(Admin admin){
        adminRepository.delete(admin);
    }



}
