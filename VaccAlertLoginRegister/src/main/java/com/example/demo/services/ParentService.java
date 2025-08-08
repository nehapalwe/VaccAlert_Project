package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ParentRegisterDTO;
import com.example.demo.entities.Login;
import com.example.demo.entities.Parent;
import com.example.demo.entities.Role;
import com.example.demo.repositories.LoginRepository;
import com.example.demo.repositories.ParentRepository;

@Service
public class ParentService {
	
	@Autowired
	ParentRepository prepo;
	
	@Autowired
    LoginRepository lrepo;
    
    @Autowired
    RoleService roleService;
	
	public Parent getParent(Login u) {
		
		return prepo.getParent(u);
	}
	
	 public Parent registerParent(ParentRegisterDTO dto) {
	        // Get Parent Role (role_id = 3 assumed for parent)
	        Role parentRole = roleService.getRole(3);

	        // Create Login entry for 'users' table
	        Login login = new Login(
	            dto.getName(),
	            dto.getPassword(),
	            dto.getEmail(),
	            dto.getContactNo(),
	            parentRole,
	            true // status = 1 for active
	        );
	        login = lrepo.save(login);

	        // Create Parent entry for 'parents' table
	        Parent parent = new Parent();
	        parent.setAadharNumber(dto.getAadharNumber());
	        parent.setAddress(dto.getAddress());
	        parent.setFirstName(dto.getFirstName());
	        parent.setLastName(dto.getLastName());
	        parent.setOccupation(dto.getOccupation());
	        parent.setUserId(login);

	        return prepo.save(parent);
	    }
	
	}

