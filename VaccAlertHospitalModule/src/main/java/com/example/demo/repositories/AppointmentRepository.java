package com.example.demo.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.AppointmentView;
import com.example.demo.entities.ChildVaccinationRecord;
@Repository
public interface AppointmentRepository extends JpaRepository<ChildVaccinationRecord, Integer> {
	
	@Query("""
		    SELECT new com.example.demo.dto.AppointmentView(
		        c.childName, c.dob, c.gender, c.medicalHistory, c.bloodGroup,
		        p.firstName, p.lastName, u.email, u.contactNo,
		        v.vaccineName, cvr.nextDueDate
		    )
		    FROM ChildVaccinationRecord cvr
		    JOIN cvr.childId c
		    JOIN c.parentId p
		    JOIN p.userId u
		    JOIN cvr.vaccineId v
		    WHERE cvr.hospitalId.hospitalId = :hospitalId
		    ORDER BY cvr.nextDueDate ASC
		""")
		List<AppointmentView> getAppointmentsByHospital(int hospitalId);

}
