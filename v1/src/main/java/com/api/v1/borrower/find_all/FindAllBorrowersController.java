package com.api.v1.borrower.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.borrower.Borrower;

@RestController
@RequestMapping("api/v1/borrowers")
public class FindAllBorrowersController {
	
	private final FindAllBorrowersService service;
	
	public FindAllBorrowersController(FindAllBorrowersService service) {
        this.service = service;
    }

    @GetMapping
	@Async
	public CompletableFuture<List<Borrower>> FindAll() {
		return service.FindAll();
	}

}
