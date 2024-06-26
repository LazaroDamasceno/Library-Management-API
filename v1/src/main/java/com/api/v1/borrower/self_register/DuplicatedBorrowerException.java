package com.api.v1.borrower.self_register;

public class DuplicatedBorrowerException extends RuntimeException {

	public DuplicatedBorrowerException(String ssn) {
		super("Borrower whose ssn is %s already exist.".formatted(ssn));
	}
	
}
