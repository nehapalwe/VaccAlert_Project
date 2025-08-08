package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository lrepo;
	
	public Login getLogin(String email, String password) {
Optional<Login> optionalLogin = lrepo.getLogin(email, password);
        
        if (optionalLogin.isPresent()) {
            return optionalLogin.get();
        } else {
            return null;
        }
	}
	
	public Login getById(int userId) {
		return lrepo.findById(userId).get();
	}
	
	public Login save(Login l) {
		return lrepo.save(l);
	}
}
