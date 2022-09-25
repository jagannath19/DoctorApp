package com.doctorapp.model;

public enum Specialisation {
	
	ORTHO("Orthopeadician"),
	PEADO("Pediatrician"),
	DIABETIC("Diabetician"),
	CARDIO("Cardiologist"),
	PHYSICIAN("General Physician");
	
	public String type;
	private Specialisation(String type) {
		this.type=type;
	}
	
}
