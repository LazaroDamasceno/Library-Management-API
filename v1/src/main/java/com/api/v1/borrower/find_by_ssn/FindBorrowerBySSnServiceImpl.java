package com.api.v1.borrower.find_by_ssn;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.BorrowerRepository;
import com.api.v1.customized_annotations.SSN;

@Service
class FindBorrowerBySsnServiceImpl implements FindBorrowerBySsnService {
	
	private final BorrowerRepository repository;

	public FindBorrowerBySsnServiceImpl(BorrowerRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public Borrower findBySsn(@SSN String ssn) {
		Optional<Borrower> optional = repository.findBySsn(ssn);
		if (optional.isEmpty()) throw new BorrowerNotFoundException(ssn);
		return optional.get();
	}
	
	

}
