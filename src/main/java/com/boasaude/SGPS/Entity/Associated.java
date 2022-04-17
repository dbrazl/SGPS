package com.boasaude.SGPS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "associateds")
public class Associated {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String academicFormation;
	
	private enum HealthCare {
		INDIVIDUAL, BUSINESS
	}
	
	@Column(nullable = false)
	private HealthCare healthCare;
	
	private enum AssociatedStatus {
		ACTIVE, INACTIVE, SUSPENDED
	}
	
	@Column(nullable = false)
	private AssociatedStatus status;
	
	private enum AgeGroup {
		AGE_0_TO_10_YEARS,
		AGE_10_TO_20_YEARS,
		AGE_20_TO_30_YEARS,
		AGE_30_TO_40_YEARS,
		AGE_40_TO_50_YEARS,
		AGE_50_TO_60_YEARS,
		AGE_60_PLUS_YEARS
	}
	
	@Column(nullable = false)
	private AgeGroup ageGroup;
	
	private enum HealthCareType {
		INFIRMARY,
		APARTMENT,
		VIP
	}
	
	@Column(nullable = false)
	private HealthCareType healthCareType;
	
	@Column(nullable = false)
	private boolean dentalMedicalPlan;

	@Column(nullable = false)
	private long medicalAppointments;
	
	@Column(nullable = false)
	private long medicalExams;
	
	@Column(nullable = false)
	private String coverage;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAcademicFormation() {
		return academicFormation;
	}

	public void setAcademicFormation(String academicFormation) {
		this.academicFormation = academicFormation;
	}

	public HealthCare getHealthCare() {
		return healthCare;
	}

	public void setHealthCare(HealthCare healthCare) {
		this.healthCare = healthCare;
	}

	public AssociatedStatus getStatus() {
		return status;
	}

	public void setStatus(AssociatedStatus status) {
		this.status = status;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public HealthCareType getHealthCareType() {
		return healthCareType;
	}

	public void setHealthCareType(HealthCareType healthCareType) {
		this.healthCareType = healthCareType;
	}

	public boolean isDentalMedicalPlan() {
		return dentalMedicalPlan;
	}

	public void setDentalMedicalPlan(boolean dentalMedicalPlan) {
		this.dentalMedicalPlan = dentalMedicalPlan;
	}

	public long getMedicalAppointments() {
		return medicalAppointments;
	}

	public void setMedicalAppointments(long medicalAppointments) {
		this.medicalAppointments = medicalAppointments;
	}

	public long getMedicalExams() {
		return medicalExams;
	}

	public void setMedicalExams(long medicalExams) {
		this.medicalExams = medicalExams;
	}

	public String[] getCoverage() {
		return coverage.split(",");
	}

	public void setCoverage(String[] coverage) {
		this.coverage = String.join(",", coverage);
	}
}