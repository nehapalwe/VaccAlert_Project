package com.example.demo.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AppointmentRequest;
import com.example.demo.entities.Child;
import com.example.demo.entities.ChildVaccinationRecord;
import com.example.demo.entities.Hospital;
import com.example.demo.repositories.ChildRepository;
import com.example.demo.repositories.ChildVaccinationRecordRepository;
import com.example.demo.repositories.HospitalRepository;

@Service
public class AppointmentService {

	@Autowired
    ChildRepository childRepo;

    @Autowired
    HospitalRepository hospitalRepo;

    @Autowired
    ChildVaccinationRecordRepository recordRepo;

    public List<Child> getChildrenByParentId(int parentId) {
        return childRepo.findByParentIdParentId(parentId);
    }

    public List<Hospital> getHospitalsByName(String name) {
        return hospitalRepo.findByHospitalName(name);
    }
    
    public List<Hospital> getAllHospitals() {
        return hospitalRepo.findAll();
    }

    public ChildVaccinationRecord bookAppointment(AppointmentRequest req) {
        Child child = childRepo.findById(req.getChildId()).orElseThrow();
        Hospital hospital = hospitalRepo.findById(req.getHospitalId()).orElseThrow();

        // Create new record
        ChildVaccinationRecord record = new ChildVaccinationRecord();
        record.setChildId(child);
        record.setHospitalId(hospital);

        // Check if the child already has records
        List<ChildVaccinationRecord> existingRecords = recordRepo.findByChildIdChildIdOrderByNextDueDateDesc(req.getChildId());

        if (existingRecords.isEmpty()) {
            // First appointment for this child
            record.setDateGiven(null);
            record.setNextDueDate(req.getAppointmentDate());
        } else {
            // Follow-up appointment
            ChildVaccinationRecord lastRecord = existingRecords.get(0);
            record.setDateGiven(lastRecord.getNextDueDate());
            record.setNextDueDate(req.getAppointmentDate());
        }

        return recordRepo.save(record);
    }
	
	
}
