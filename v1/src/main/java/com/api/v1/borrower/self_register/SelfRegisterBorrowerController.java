package com.api.v1.borrower.self_register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/borrowers")
public class SelfRegisterBorrowerController {
	
	@Autowired
	private SelfRegisterBorrowerService service;
	
	@PostMapping
	public ResponseEntity<Void> selfRegister(@NotNull @RequestBody SelfRegisterBorrowerDTO dto) {
		service.selfRegister(dto);
		return ResponseEntity.status(201).build();
	}

}
