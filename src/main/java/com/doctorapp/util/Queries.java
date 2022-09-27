package com.doctorapp.util;

public class Queries {
	public static final String QueryCreate="create table doctor(DoctorName varchar(20),DoctorId integer primary key auto_increment,Speciality varchar(30),Fees Double,Experiance integer,StarTime timeStamp,EndTime timeStamp)";
	public static final String QueryAddDoctor="insert into doctor(DoctorName,Speciality,Fees,Experiance,StarTime,EndTime)"
			+ " values (?,?,?,?,?,?)";
	public static final String QueryUpdateDoctor="update doctor set Fees=? where DoctorId=?";
	public static final String QueryDoctorById="select * from doctor where DoctorId=?";	
	public static final String QueryDoctorBySpecility="select * from doctor where Speciality=?";
	public static final String QueryDoctorBySpecialityAndExperiance="select * from doctor where Speciality=? and Experiance>=?";
	public static final String QueryDoctorBySpecialityFees="select * from doctor where Speciality =? and Fees <=?";
	public static final String QueryDoctorByAvailability="select * from doctor where StartingDate=?";
	public static final String QueryDeleteDoctor="delete from doctor where DoctorId=?";
}
