package com.boasaude.SGPS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_providers")
public class ServiceProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String academicFormation;
	
	@Column(nullable = false)
	private String convened;
	
	private enum ProviderStatus {
		ACTIVE,
		INACTIVE
	}
	
	@Column(nullable = false)
	private ProviderStatus status;
	
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

	public String getConvened() {
		return convened;
	}

	public void setConvened(String convened) {
		this.convened = convened;
	}

	public ProviderStatus getStatus() {
		return status;
	}

	public void setStatus(ProviderStatus status) {
		this.status = status;
	}
}
