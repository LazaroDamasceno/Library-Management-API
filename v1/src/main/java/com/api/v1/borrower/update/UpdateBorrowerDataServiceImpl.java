package com.api.v1.borrower.update;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.BorrowerRepository;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySsnService;
import com.api.v1.customized_annotations.SSN;

import jakarta.validation.constraints.NotNull;

@Service
public class UpdateBorrowerDataServiceImpl implements UpdateBorrowerDataService {
	
	private final BorrowerRepository repository;
	private final FindBorrowerBySsnService findBorrowerBySSn;

	public UpdateBorrowerDataServiceImpl(BorrowerRepository repository, FindBorrowerBySsnService findBorrowerBySSn) {
		this.repository = repository;
		this.findBorrowerBySSn = findBorrowerBySSn;
	}

	@Override
	@Transactional
	public void updateData(@SSN String ssn, @NotNull UpdateBorrowerDataDTO dto) {
		Borrower borrower = findBorrowerBySSn.findBySsn(ssn);
		borrower.updateData(dto);
		repository.save(borrower);
	}
	
}
