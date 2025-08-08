package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Child;
import com.example.demo.entities.Parent;
import com.example.demo.repositories.ChildRepository;
import com.example.demo.repositories.ParentRepository;

@CrossOrigin(origins = "*")
@RestController
public class ChildController {
	
	@Autowired
    private ChildRepository childRepo;

    @Autowired
    private ParentRepository parentRepo;

    // Register a new child
    @PostMapping("/registerChild")
    public Child registerChild(@RequestBody Child child, @RequestParam int parentId) {
        Parent parent = parentRepo.findById(parentId).orElseThrow();
        child.setParentId(parent);
        return childRepo.save(child);
    }

    // View all children for a parent
    @GetMapping("/viewChildren")
    public List<Child> viewChildren(@RequestParam int parentId) {
        return childRepo.findByParentIdParentId(parentId);
    }
}
