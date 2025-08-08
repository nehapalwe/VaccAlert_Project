/**
 * 
 */
package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.VaccinationInfoDTO;
import com.example.demo.entities.ChildVaccinationRecord;

/**
 * 
 */
public interface ChildVaccinationRecordRepository extends JpaRepository<ChildVaccinationRecord, Integer> {
	
	List<ChildVaccinationRecord> findByChildIdChildIdOrderByNextDueDateDesc(int childId);
	
	@Query("SELECT new com.example.demo.dto.VaccinationInfoDTO(c.childName, r.dateGiven, null, h.hospitalName, v.vaccineName) " +
		       "FROM ChildVaccinationRecord r " +
		       "JOIN r.childId c " +
		       "JOIN r.hospitalId h " +
		       "JOIN r.vaccineId v " +
		       "WHERE c.parentId.parentId = :parentId AND r.dateGiven IS NOT NULL")
		List<VaccinationInfoDTO> getVaccinationHistory(@Param("parentId") int parentId);

	@Query("SELECT new com.example.demo.dto.VaccinationInfoDTO(c.childName, r.dateGiven, r.nextDueDate, h.hospitalName, v.vaccineName) " +
		       "FROM ChildVaccinationRecord r " +
		       "JOIN r.childId c " +
		       "JOIN r.hospitalId h " +
		       "JOIN r.vaccineId v " +
		       "WHERE c.parentId.parentId = :parentId AND r.nextDueDate >= CURRENT_DATE")
		List<VaccinationInfoDTO> getUpcomingVaccinations(@Param("parentId") int parentId);


}
