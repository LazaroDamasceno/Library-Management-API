package com.api.v1.borrower.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.api.v1.borrower.Borrower;

public interface FindAllBorrowersService {

	CompletableFuture<List<Borrower>> FindAll();
	
}
