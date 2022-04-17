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
import com.boasaude.SGPS.Entity.ServiceProvider;
import com.boasaude.SGPS.Repository.ServiceProviderRepository;

import jakarta.validation.Valid;

@RestController
public class ServiceProvidersController {
	
	@Autowired
	private ServiceProviderRepository _serviceProviderRepository;

	@GetMapping("/serviceProviders")
	public ResponseEntity<List<ServiceProvider>> Get() {
		return new ResponseEntity<List<ServiceProvider>>(_serviceProviderRepository.findAllAndSort(), HttpStatus.OK);
	}
	
	@PostMapping("/serviceProviders")
	public ResponseEntity<ServiceProvider> Post (@Valid @RequestBody ServiceProvider serviceProvider) {
		try {
			return new ResponseEntity<ServiceProvider>(_serviceProviderRepository.save(serviceProvider), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/serviceProviders/{id}")
	public ResponseEntity<ServiceProvider> Put(@PathVariable ("id") long id, @Valid @RequestBody ServiceProvider serviceProvider) {
		Optional<ServiceProvider> oldData= _serviceProviderRepository.findById(id);
		
		if(oldData.isPresent()) {
			ServiceProvider newData= oldData.get();
			
			newData.setName(serviceProvider.getName());
			newData.setAddress(serviceProvider.getAddress());
			newData.setAcademicFormation(serviceProvider.getAcademicFormation());
			newData.setConvened(serviceProvider.getConvened());
			newData.setStatus(serviceProvider.getStatus());
			
			try {
				_serviceProviderRepository.save(newData);
				return new ResponseEntity<ServiceProvider>(newData, HttpStatus.OK);
			} catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/serviceProviders/{id}")
	public ResponseEntity<Object> Delete(@PathVariable ("id") long id) {
		Optional<ServiceProvider> associated = _serviceProviderRepository.findById(id);
		
		if(associated.isPresent()) {
			_serviceProviderRepository.delete(associated.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
