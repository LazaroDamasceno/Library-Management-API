package com.api.v1.borrower.find_by_ssn;

class BorrowerNotFoundException extends RuntimeException {

	public BorrowerNotFoundException(String ssn) {
		super("Borrower whose ssn is %s was not found.".formatted(ssn));
	}

}
