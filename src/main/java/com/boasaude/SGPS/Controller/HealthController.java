package com.boasaude.SGPS.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boasaude.SGPS.Entity.Associated;

@RestController
public class HealthController {

	@GetMapping("/health")
	public ResponseEntity<List<Associated>> Get() {
		return new ResponseEntity(null, HttpStatus.OK);
	}
}
