package com.api.v1.borrower.find_by_ssn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.BorrowerRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Service
public class FindBorrowerBySSnServiceImpl implements FindBorrowerBySSnService {
	
	@Autowired
	private BorrowerRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Borrower findBySsn(@NotNull @Size(min = 9, max = 9) String ssn) {
		Optional<Borrower> optional = repository.findBySsn(ssn);
		if (optional.isEmpty()) throw new BorrowerNotFoundException(ssn);
		return optional.get();
	}
	
	

}
