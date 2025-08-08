package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminRegisterDTO;
import com.example.demo.entities.Login;
import com.example.demo.entities.Role;
import com.example.demo.repositories.LoginRepository;

@Service
public class AdminService {
	
	@Autowired
    private LoginRepository loginRepo;

    @Autowired
    private RoleService roleService;

    public Login registerAdmin(AdminRegisterDTO dto) {
        Role adminRole = roleService.getRole(1); // Assuming role_id=1 for Admin
        Login login = new Login(
            dto.getName(),
            dto.getPassword(),
            dto.getEmail(),
            dto.getContactNo(),
            adminRole,
            true // status = 1
        );
        return loginRepo.save(login);
    }
}
