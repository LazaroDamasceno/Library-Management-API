package com.api.v1.borrower.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.BorrowerRepository;
import com.api.v1.borrower.find_by_ssn.FindBorrowerBySSnService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Service
public class UpdateBorrowerDataServiceImpl implements UpdateBorrowerDataService {
	
	@Autowired
	private BorrowerRepository repository;
	
	@Autowired
	private FindBorrowerBySSnService findBorrowerBySSn;

	@Override
	@Transactional
	public void updateData(@NotNull @Size(min = 9, max = 9) String ssn, @NotNull UpdateBorrowerDataDTO dto) {
		Borrower borrower = findBorrowerBySSn.findBySsn(ssn);
		borrower.updateData(dto);
		repository.save(borrower);
	}
	
}
