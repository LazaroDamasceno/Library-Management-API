package com.api.v1.borrower.update;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/borrowers")
@RequiredArgsConstructor
public class UpdateBorrowerDataController {

	private final UpdateBorrowerDataService service;
	
	@PutMapping("{ssn}")
	public ResponseEntity<Void> updateData(
			@NotNull @PathVariable @Size(min = 9, max = 9 ) String ssn, 
			@NotNull @RequestBody UpdateBorrowerDataDTO dto
	) {
		service.updateData(ssn, dto);
		return ResponseEntity.status(204).build();
	}
	
}
