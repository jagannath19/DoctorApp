package com.doctorapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.DbConnection;
import com.doctorapp.util.Queries;

public class DoctorDaoImpl implements IDoctorDao {
	Connection connection;
	PreparedStatement prepairedstatement=null;
	LocalDateTime now = LocalDateTime.now();
    Timestamp timestamp = Timestamp.valueOf(now);
	
	
	@Override
	public void addDoctor(Doctor doctor) {
		try {
			 connection=DbConnection.openConnection();
			
			prepairedstatement=connection.prepareStatement(Queries.QueryAddDoctor);
			prepairedstatement.setString(1, doctor.getDoctorName());
//			prepairedstatement.setInt(2, doctor.getDoctorId());
			prepairedstatement.setString(2, doctor.getSpeciality());
			prepairedstatement.setDouble(3, doctor.getFees());
			prepairedstatement.setInt(4, doctor.getExperiance());
			prepairedstatement.setTimestamp(5,Timestamp.valueOf(doctor.getStartTime()));
			prepairedstatement.setTimestamp(6, Timestamp.valueOf(doctor.getEndTime()));
			boolean val=prepairedstatement.execute();
			if(!val) {
				System.out.println("Doctor added");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		
	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		
		try {
			prepairedstatement=connection.prepareStatement(Queries.QueryUpdateDoctor);
			prepairedstatement.setDouble(1, fees);
			prepairedstatement.setInt(2, doctorId);
			int val=prepairedstatement.executeUpdate();
			if(val==1)
				System.out.println("Fees added");
			else
				System.out.println("Invalid dotor id");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
	}
	
	
	@Override
	public Doctor findById(int doctorId) {
		Doctor doctor=null;
		try {
			connection=DbConnection.openConnection();
			prepairedstatement=connection.prepareStatement(Queries.QueryDoctorById);
			prepairedstatement.setInt(1, doctorId);
			ResultSet resultset=prepairedstatement.executeQuery();
			while(resultset.next()) {
				doctor=new Doctor();
				doctor.setDoctorName(resultset.getString(1));
				doctor.setDoctorId(resultset.getInt(2));
				doctor.setSpeciality(resultset.getString(3));
				doctor.setFees(resultset.getDouble(4));
				doctor.setExperiance(resultset.getInt(5));
				doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		
		return doctor;
	}

	@Override
	public void deleteDoctor(int doctorId) {
		connection=DbConnection.openConnection();
		try {
			prepairedstatement=connection.prepareStatement(Queries.QueryDeleteDoctor);
			prepairedstatement.setInt(1, doctorId);
			boolean val=prepairedstatement.execute();
			if(val==false)
				System.out.println("Doctor details deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		connection=DbConnection.openConnection();
		Doctor doctor=null;
		List<Doctor> doctorList=new ArrayList<Doctor>();
		try {
			prepairedstatement=connection.prepareStatement(Queries.QueryDoctorBySpecility);
			prepairedstatement.setString(1, speciality);
			ResultSet resultset=prepairedstatement.executeQuery();
			while(resultset.next()) {
			doctor=new Doctor();
			doctor.setDoctorName(resultset.getString(1));
			doctor.setDoctorId(resultset.getInt(2));
			doctor.setSpeciality(resultset.getString(3));
			doctor.setFees(resultset.getDouble(4));
			doctor.setExperiance(resultset.getInt(5));
			doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
			doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());
			doctorList.add(doctor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experiance) {
		
		connection=DbConnection.openConnection();
		Doctor doctor=null;
		List<Doctor> doctorList=new ArrayList<Doctor>();
		try {
			prepairedstatement=connection.prepareStatement(Queries.QueryDoctorBySpecialityAndExperiance);
			prepairedstatement.setString(1, speciality);
			prepairedstatement.setInt(2, experiance);
			ResultSet resultset=prepairedstatement.executeQuery();
			while(resultset.next()) {
			doctor=new Doctor();
			doctor.setDoctorName(resultset.getString(1));
			doctor.setDoctorId(resultset.getInt(2));
			doctor.setSpeciality(resultset.getString(3));
			doctor.setFees(resultset.getDouble(4));
			doctor.setExperiance(resultset.getInt(5));
			doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
			doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());
			doctorList.add(doctor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
		connection=DbConnection.openConnection();
		Doctor doctor=null;
		List<Doctor> doctorList=new ArrayList<Doctor>();
		try {
			prepairedstatement=connection.prepareStatement(Queries.QueryDoctorBySpecialityFees);
			prepairedstatement.setString(1, speciality);
			prepairedstatement.setDouble(2, fees);
			ResultSet resultset=prepairedstatement.executeQuery();
			while(resultset.next()) {
			doctor=new Doctor();
			doctor.setDoctorName(resultset.getString(1));
			doctor.setDoctorId(resultset.getInt(2));
			doctor.setSpeciality(resultset.getString(3));
			doctor.setFees(resultset.getDouble(4));
			doctor.setExperiance(resultset.getInt(5));
			doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
			doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());
			doctorList.add(doctor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getByAvailability(LocalDateTime startTime) {
		connection=DbConnection.openConnection();
		Doctor doctor=null;
		Timestamp timeStamp=Timestamp.valueOf(startTime);
		List<Doctor> doctorList=new ArrayList<Doctor>();
		try {
			prepairedstatement=connection.prepareStatement(Queries.QueryDoctorByAvailability);
			prepairedstatement.setTimestamp(1, timeStamp);
			ResultSet resultset=prepairedstatement.executeQuery();
			while(resultset.next()) {
			doctor=new Doctor();
			doctor.setDoctorName(resultset.getString(1));
			doctor.setDoctorId(resultset.getInt(2));
			doctor.setSpeciality(resultset.getString(3));
			doctor.setFees(resultset.getDouble(4));
			doctor.setExperiance(resultset.getInt(5));
			doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
			doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());
			doctorList.add(doctor);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepairedstatement!=null)
					prepairedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbConnection.closeConnection();
		}
		return doctorList;
	}

}
