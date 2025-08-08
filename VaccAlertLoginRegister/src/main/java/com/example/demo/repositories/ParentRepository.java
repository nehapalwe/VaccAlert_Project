package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Login;
import com.example.demo.entities.Parent;
@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {
	
	@Query("select p from Parent p where userId= :u")
	public Parent getParent(Login u);
}
