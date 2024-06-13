package com.api.v1.borrower.self_register;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.BorrowerRepository;

import jakarta.validation.constraints.NotNull;

@Service
class SelfRegisterBorrowerServiceImpl implements SelfRegisterBorrowerService {
	
	private final BorrowerRepository repository;

	public SelfRegisterBorrowerServiceImpl(BorrowerRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public void selfRegister(@NotNull SelfRegisterBorrowerDTO dto) {
		Borrower borrower = Borrower.createInstance(dto);
		validateData(dto.ssn());
		repository.save(borrower);
	}
	
	private void validateData(String ssn) {
		if (repository.findBySsn(ssn).isPresent()) {
			throw new DuplicatedBorrowerException(ssn);
		}
	}

}
