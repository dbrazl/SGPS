package com.boasaude.SGPS.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boasaude.SGPS.Entity.Associated;
import com.boasaude.SGPS.Repository.AssociatedRepository;

import jakarta.validation.Valid;

@RestController
public class AssociatedController {

	@Autowired
	private AssociatedRepository _associatedRepository;
	
	@GetMapping("/associateds")
	public ResponseEntity<List<Associated>> Get() {
		return new ResponseEntity<List<Associated>>(_associatedRepository.findAllAndSort(), HttpStatus.OK);
	}
	
	@PostMapping("/associateds")
	public ResponseEntity<Associated> Post (@Valid @RequestBody Associated associated) {
		try {
			return new ResponseEntity<Associated>(_associatedRepository.save(associated), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/associateds/{id}")
	public ResponseEntity<Associated> Put(@PathVariable ("id") long id, @Valid @RequestBody Associated associated) {
		Optional<Associated> oldData= _associatedRepository.findById(id);
		
		if(oldData.isPresent()) {
			Associated newData= oldData.get();
			
			newData.setName(associated.getName());
			newData.setAddress(associated.getAddress());
			newData.setAcademicFormation(associated.getAcademicFormation());
			newData.setHealthCare(associated.getHealthCare());
			newData.setStatus(associated.getStatus());
			newData.setAgeGroup(associated.getAgeGroup());
			newData.setHealthCareType(associated.getHealthCareType());
			newData.setDentalMedicalPlan(associated.isDentalMedicalPlan());
			newData.setMedicalAppointments(associated.getMedicalAppointments());
			newData.setMedicalExams(associated.getMedicalExams());
			newData.setCoverage(associated.getCoverage());
			
			try {
				_associatedRepository.save(newData);
				return new ResponseEntity<Associated>(newData, HttpStatus.OK);
			} catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/associateds/{id}")
	public ResponseEntity<Object> Delete(@PathVariable ("id") long id) {
		Optional<Associated> associated = _associatedRepository.findById(id);
		
		if(associated.isPresent()) {
			_associatedRepository.delete(associated.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}