package com.api.v1.borrower.find_by_ssn;

import com.api.v1.borrower.Borrower;
import com.api.v1.customized_annotations.SSN;

public interface FindBorrowerBySsnService {

	Borrower findBySsn(@SSN String ssn);
	
}
