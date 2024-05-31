package com.api.v1.borrower.self_register;

public class DuplicatedBorrowerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicatedBorrowerException(String ssn) {
		super("Borrower whose ssn is %s already exist.".formatted(ssn));
	}
	
}
