package com.api.v1.borrower.find_by_ssn;

import com.api.v1.borrower.Borrower;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindBorrowerBySSnService {

	Borrower findBySsn(@NotNull @Size(min = 9, max = 9) String ssn);
	
}
