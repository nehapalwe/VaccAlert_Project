package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Child;

public interface ChildRepository extends JpaRepository<Child, Integer> {
	
	List<Child> findByParentIdParentId(int parentId);
}
