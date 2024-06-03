package com.api.v1.borrower.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.borrower.Borrower;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/borrowers")
@RequiredArgsConstructor
public class FindAllBorrowersController {
	
	private final FindAllBorrowersService service;
	
	@GetMapping
	public ResponseEntity<List<Borrower>> FindAll() {
		return ResponseEntity.ok(service.FindAll());
	}

}
