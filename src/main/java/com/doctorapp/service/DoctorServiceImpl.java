package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.doctor.exception.DoctorNotFoundException;
import com.doctor.exception.SpecialityNotFoundException;
import com.doctorapp.dao.DoctorDaoImpl;
import com.doctorapp.dao.IDoctorDao;
import com.doctorapp.model.Doctor;

public class DoctorServiceImpl implements IDoctorService {
	IDoctorDao dao=new DoctorDaoImpl();

	@Override
	public void addDoctor(Doctor doctor) {
		dao.addDoctor(doctor);
	}

	@Override
	public void updateDoctor(int doctorId, double fees) throws DoctorNotFoundException{
		dao.updateDoctor(doctorId, fees);
	}
	
	@Override
	public Doctor findById(int doctorId) throws DoctorNotFoundException{
			Doctor doctor=dao.findById(doctorId);
			if (doctor!=null)
				return doctor;
			else 
				throw new DoctorNotFoundException("Doctor id missmatch");
	}

	@Override
	public void deleteDoctor(int doctorId) {
		dao.deleteDoctor(doctorId);
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws SpecialityNotFoundException{
		List<Doctor> doctors=dao.getBySpeciality(speciality);
		if(doctors!=null) {
		return doctors.stream()
				.sorted((name1,name2)->name1.getDoctorName().compareToIgnoreCase(name2.getDoctorName()))
				.collect(Collectors.toList());}
		else 
			throw new SpecialityNotFoundException("Speciality missmatch");
						
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experiance) throws SpecialityNotFoundException{
		
		List<Doctor> doctors=dao.getBySpecialityAndExp(speciality, experiance);
		if(doctors!=null)
		return doctors.stream()
				.sorted((name1,name2)->name1.getDoctorName().compareToIgnoreCase(name2.getDoctorName()))
				.collect(Collectors.toList());
		else
			throw new SpecialityNotFoundException("Speciality or experiance not match");
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws SpecialityNotFoundException{
		
		List<Doctor> doctors=dao.getBySpecialityAndFees(speciality, fees);
		if(doctors!=null)
		return doctors.stream()
				.sorted((name1,name2)->name1.getDoctorName().compareToIgnoreCase(name2.getDoctorName()))
				.collect(Collectors.toList());
		else
			throw new SpecialityNotFoundException("Speciality or fees not match");
	}

	@Override
	public List<Doctor> getByAvailability(LocalDateTime startTime) throws SpecialityNotFoundException{
		List<Doctor> doctors=dao.getByAvailability(startTime);
		if(doctors!=null)
		return doctors.stream()
				.sorted((name1,name2)->name1.getDoctorName().compareToIgnoreCase(name2.getDoctorName()))
				.collect(Collectors.toList());
		else 
			throw new  SpecialityNotFoundException("Given date andtime not found");
	}

	
	

}
