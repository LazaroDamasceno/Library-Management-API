package com.api.v1.borrower.self_register;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.BorrowerBuilder;
import com.api.v1.borrower.BorrowerRepository;

import jakarta.validation.constraints.NotNull;

@Service
public class SelfRegisterBorrowerServiceImpl implements SelfRegisterBorrowerService {
	
	private final BorrowerRepository repository;

	public SelfRegisterBorrowerServiceImpl(BorrowerRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public void selfRegister(@NotNull SelfRegisterBorrowerDTO dto) {
		validateData(dto.ssn());
		setBorrowerWhenMiddleNameIsNull(dto);
		setBorrowerWhenMiddleNameIsNotNull(dto);
	}

	private void setBorrowerWhenMiddleNameIsNull(SelfRegisterBorrowerDTO dto) {
		if (dto.middleName() == null) {
			Borrower borrower = new BorrowerBuilder(
				dto.firstName(),
				dto.lastName(),
				dto.ssn(),
				dto.birthDate(),
				dto.email(),
				dto.address(), 
				dto.gender(),
				dto.phoneNumber()
			).build();
			repository.save(borrower);
		}

	}

	private void setBorrowerWhenMiddleNameIsNotNull(SelfRegisterBorrowerDTO dto) {
		if (dto.middleName() != null) {
			Borrower borrower = new BorrowerBuilder(
				dto.firstName(),
				dto.lastName(),
				dto.ssn(),
				dto.birthDate(),
				dto.email(),
				dto.address(), 
				dto.gender(),
				dto.phoneNumber()
			).middleName(dto.middleName()).build();
			repository.save(borrower);
		}
	}
	
	private void validateData(String ssn) {
		if (repository.findBySsn(ssn).isPresent()) {
			throw new DuplicatedBorrowerException(ssn);
		}
	}

}
