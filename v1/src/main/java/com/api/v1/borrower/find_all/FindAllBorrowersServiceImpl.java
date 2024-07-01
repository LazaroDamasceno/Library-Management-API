package com.api.v1.borrower.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.BorrowerRepository;

@Service
public class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

	private final BorrowerRepository repository;
	
	public FindAllBorrowersServiceImpl(BorrowerRepository repository) {
		this.repository = repository;
	}

	@Override
	@Async
	public CompletableFuture<List<Borrower>> FindAll() {
		return CompletableFuture.completedFuture(repository.findAll());
	}

}
