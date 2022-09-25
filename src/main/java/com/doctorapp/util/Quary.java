package com.doctorapp.util;

public class Quary {
	public static final String createQuary="create table doctor(DoctorName varchar(20),DoctorId integer primary key auto_increment,Speciality varchar(30),Fees Double,Experiance integer,StarTime timeStamp,EndTime timeStamp)";
	public static final String addDoctorQuary="insert into doctor(DoctorName,Speciality,Fees,Experiance,StarTime,EndTime)"
			+ " values (?,?,?,?,?,?)";
	public static final String updateDoctorquary="update doctor set Fees=? where DoctorId=?";
	public static final String findDoctorById="select * from doctor where DoctorId=?";	
	public static final String getBySpecilityQuary="select * from doctor where Speciality=?";
	public static final String getBySpecialityExperianceQuary="select * from doctor where Speciality=? and Experiance>=?";
	public static final String getBySpecialityFeesQuary="select * from doctor where Speciality =? and Fees <=?";
	public static final String getByAvailabilityQuary="select * from doctor where StartingDate=?";
	public static final String deleteDoctor="delete from doctor where DoctorId=?";
}
