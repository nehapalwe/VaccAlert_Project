package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LoginInfo;
import com.example.demo.entities.User;
import com.example.demo.entities.UserInfoResponse;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.UserDetailsImple;
import com.example.demo.services.JwtUtils;

@RestController
public class FirstController {
	
	@Autowired
	AuthenticationManager authManager;
    
	@Autowired
	UserRepository urepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@GetMapping("/public")
	public String publicroute() {
		return "For all";		
	}

	@GetMapping("/admin")
	public String adminroute() {
		return "For admin";		
	}
	
	@GetMapping("/user")
	public String userroute() {
		return "For user";		
	}	
	
	@PostMapping("/login") 
	public ResponseEntity<?> checkLogin(@RequestBody LoginInfo linfo)  {
		
		//may throw exception DisabledException or LockedException or BadCredentialsException
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(linfo.getUsername(), linfo.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetailsImple userDetails = (UserDetailsImple)authentication.getPrincipal();
		
		String token = jwtUtils.generateTokenFromUsername(userDetails.getUsername());
		
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) userDetails.getAuthorities();
		String role = authorities.get(0).getAuthority();
		
		return ResponseEntity.ok(new UserInfoResponse( userDetails.getUsername(), role, token));
	}
	
	
	@PostMapping("/register")
	public boolean register(@RequestBody User u) {
		System.out.println(u.getUsername()+" : "+u.getPassword()+" : "+u.getRoles());
		u.setPassword(encoder.encode(u.getPassword()));
		System.out.println(u.getUsername()+" : "+u.getPassword()+" : "+u.getRoles());
		try{
			urepo.save(u);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}


}
