package com.School.StudentManagementSystem.service;

import com.School.StudentManagementSystem.repository.AdminRepository;
import com.School.StudentManagementSystem.entity.Admin;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailService implements UserDetailsService {
    AdminRepository adminRepository;

    public AdminDetailService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No admin with email: " + email));

        return User
                .withUsername(admin.getEmail())
                .password(admin.getPassword())
                .authorities("ROLE_USER")
                .build();
    }
}
