package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VaccinationInfoDTO;
import com.example.demo.repositories.ChildVaccinationRecordRepository;

@RestController
@CrossOrigin(origins = "*")
public class VaccinationController {
	private final ChildVaccinationRecordRepository recordRepo;

    public VaccinationController(ChildVaccinationRecordRepository recordRepo) {
        this.recordRepo = recordRepo;
    }

    @GetMapping("/vaccinationHistory")
    public List<VaccinationInfoDTO> getVaccinationHistory(@RequestParam int parentId) {
        return recordRepo.getVaccinationHistory(parentId);
    }

    @GetMapping("/upcomingVaccinations")
    public List<VaccinationInfoDTO> getUpcomingVaccinations(@RequestParam int parentId) {
        return recordRepo.getUpcomingVaccinations(parentId);
    }
}
