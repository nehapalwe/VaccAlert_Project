package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer> {

}
