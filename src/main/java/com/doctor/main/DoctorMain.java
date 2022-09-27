package com.doctor.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialisation;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

public class DoctorMain {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		boolean flag=false;
		IDoctorService doctorService=new DoctorServiceImpl();
		System.out.println("Welcome to Apna medical");
//		con.getConnection();
		do {
		System.out.println("press 1 for Admin \npress 2 for customer ");
		int baseChoice=scn.nextInt();
		switch(baseChoice) {
		case 1:
			System.out.println("Press 1 for Add doctor");
			System.out.println("Press 2 for Update doctor fees");
			System.out.println("Press 3 for find doctor by id");
			System.out.println("Press 4 for delete doctor");
			int adminChoice=scn.nextInt();
			switch(adminChoice) {
			case 1:
				System.out.println("Enter the doctor name");
				scn.nextLine();
				String doctorName=scn.nextLine();
				
				System.out.println("Specialisation - \n1-ORTHOPEADICIAN \n2-PEDIATRICIAN\n3-DIABETICIAN\n"
						+ "4-CARDIOLOGIST \n5-GENERAL PHYSICIAN");
					int specInput=scn.nextInt();
					scn.nextLine();
					String speciality=Specialisation.values()[specInput-1].toString();
					System.out.println(speciality);

					
				System.out.println("Enter the fees");
				double fees=scn.nextDouble();
				System.out.println("enter the experiance");
				int experiance=scn.nextInt();
				System.out.println("Enter the start date as yyyy-mm-dd");
				String startDate=scn.next();
				LocalDate localStartDate=LocalDate.parse(startDate);
				System.out.println("Enter the start time as hh:mm");
				String startTime=scn.next();
				LocalTime localStartTime=LocalTime.parse(startTime);
				LocalDateTime startDateTime=LocalDateTime.of(localStartDate, localStartTime);
				
				System.out.println("Enter the end date as yyyy-mm-dd");
				String endDate=scn.next();
				LocalDate localEndDate=LocalDate.parse(endDate);
				System.out.println("Enter the end time as hh:mm");
				String endTime=scn.next();
				LocalTime localEndTime=LocalTime.parse(endTime);
				LocalDateTime endDateTime=LocalDateTime.of(localEndDate, localEndTime);
				doctorService.addDoctor(new Doctor(doctorName, speciality, fees, experiance, startDateTime, endDateTime));
				break;
			case 2:
				System.out.println("Enter the doctor Id");
				int doctorId=scn.nextInt();
				System.out.println("Enter the fees for update");
				double updateFees=scn.nextDouble();
				doctorService.updateDoctor(doctorId, updateFees);
				break;
			case 3:
				System.out.println("Enter doctorId");
				int findDoctorId=scn.nextInt();
				System.out.println( doctorService.findById(findDoctorId));
				break;
			case 4:
				System.out.println("Enter doctor Id");
				int doctorIdForDelete=scn.nextInt();
				doctorService.deleteDoctor(doctorIdForDelete);
				break;
				default:
					System.out.println("Invalid input");
			}
			break;
		case 2:
			System.out.println("press 1 for get doctor by speciality");
			System.out.println("press 2 for get doctor by speciality and Experiance");
			System.out.println("press 3 for get doctor by speciality and fees");
			System.out.println("press 4 for get doctor by availability");
			int customerChoice=scn.nextInt();
			switch(customerChoice) {
			case 1:
				System.out.println("Specialisation - \n1-ORTHOPEADICIAN \n2-PEDIATRICIAN\n3-DIABETICIAN\n"
						+ "4-CARDIOLOGIST \n5-GENERAL PHYSICIAN");
					int specInput=scn.nextInt();
					scn.nextLine();
					String speciality=Specialisation.values()[specInput-1].toString();
					for(Doctor doctor:doctorService.getBySpeciality(speciality)) {
						System.out.println(doctor);
					}
				break;
			case 2:
				System.out.println("Specialisation - \n1-ORTHOPEADICIAN \n2-PEDIATRICIAN\n3-DIABETICIAN\n"
						+ "4-CARDIOLOGIST \n5-GENERAL PHYSICIAN");
					 specInput=scn.nextInt();
					scn.nextLine();
					 speciality=Specialisation.values()[specInput-1].toString();
				System.out.println("Enter the Experiance");
				int experianceInput=scn.nextInt();
				
				for(Doctor doctor:doctorService.getBySpecialityAndExp(speciality, experianceInput)) {
					System.out.println(doctor);
				}
				break;
			case 3:
				System.out.println("Specialisation - \n1-ORTHOPEADICIAN \n2-PEDIATRICIAN\n3-DIABETICIAN\n"
						+ "4-CARDIOLOGIST \n5-GENERAL PHYSICIAN");
					 specInput=scn.nextInt();
					scn.nextLine();
					speciality=Specialisation.values()[specInput-1].toString();
				
				System.out.println("Enter fees");
				double feesInput=scn.nextDouble();
				for(Doctor doctor:doctorService.getBySpecialityAndFees(speciality, feesInput)) {
					System.out.println(doctor);
				}
				break;
			case 4:
				System.out.println("Enter the date in form of yyyy-mm-dd");
				String date=scn.next();
				LocalDate localDate=LocalDate.parse(date);
				System.out.println("Enter the time in form of hh:mm");
				String time=scn.next();
				LocalTime localTime=LocalTime.parse(time);
				
				LocalDateTime dateTime=LocalDateTime.of(localDate, localTime);
				
				for(Doctor doctor:doctorService.getByAvailability(dateTime)) {
					System.out.println(doctor);
				}
				break;
				default:
					System.out.println("Invalid Input");}
			
			}
		System.out.println("press 1 for continue \npress 2 for exit");
		int ch=scn.nextInt();
		if(ch==1)
			flag=true;
		else
			flag=false;
		}
			while(flag);
			System.out.println("Thank you for visit us");
			scn.close();
	}
}
