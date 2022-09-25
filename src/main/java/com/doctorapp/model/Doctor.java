package com.doctorapp.model;

import java.time.LocalDateTime;

public class Doctor {
	private String doctorName;
	private Integer doctorId;
	private String speciality;
	private double fees;
	private int experiance;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String doctorName,  String speciality, double fees, int experiance,
			LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.doctorName = doctorName;
//		this.doctorId = doctorId;
		this.speciality = speciality;
		this.fees = fees;
		this.experiance = experiance;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int getExperiance() {
		return experiance;
	}
	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", doctorId=" + doctorId + ", speciality=" + speciality + ", fees="
				+ fees + ", experiance=" + experiance +"years" +", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
	
}
