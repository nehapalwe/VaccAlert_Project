package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService createUsers() {
		UserDetails user = User.withUsername("user")
				.password(passwordEncoder().encode("password"))
				.roles("user")
				.build();
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("admin","user")
				.build();
		return new InMemoryUserDetailsManager(user,admin);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(authorize -> {
		  authorize.requestMatchers("/all").permitAll();
		  authorize.requestMatchers("/user").hasAnyRole("user","admin");
		  authorize.requestMatchers("/admin").hasRole("admin");		  
		})
		.formLogin(Customizer.withDefaults());		
		return http.build();
	}
	
	
	
	
}
