package com.doctorapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorDao {
	void addDoctor(Doctor doctor);
	void updateDoctor(int doctorId,double fees);
	
	Doctor findById(int doctorId);
	void deleteDoctor(int doctorId);
	
	List<Doctor> getBySpeciality(String speciality);
	List<Doctor> getBySpecialityAndExp(String speciality,int experiance);
	List<Doctor> getBySpecialityAndFees(String speciality,double fees);
	List<Doctor> getByAvailability(LocalDateTime startTime);
	
}
