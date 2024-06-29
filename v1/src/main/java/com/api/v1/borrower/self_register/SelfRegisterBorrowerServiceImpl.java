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
	private final BorrowerBuilder builder;

    public SelfRegisterBorrowerServiceImpl(BorrowerBuilder builder, BorrowerRepository repository) {
        this.builder = builder;
        this.repository = repository;
    }



	@Override
	@Transactional
	public void selfRegister(@NotNull SelfRegisterBorrowerDTO dto) {
		validateData(dto.ssn());
		setBorrowerIfMiddleNameIsNull(dto);
		setBorrowerIfMiddleNameIsNotNull(dto);
	}

	private void setBorrowerIfMiddleNameIsNull(SelfRegisterBorrowerDTO dto) {
		if (dto.middleName() == null) {
			var borrower = builder.create(dto).build();
			repository.save(borrower);
		}

	}

	private void setBorrowerIfMiddleNameIsNotNull(SelfRegisterBorrowerDTO dto) {
		if (dto.middleName() != null) {
			Borrower borrower = builder.create(dto).withMiddleName(dto.middleName()).build();
			repository.save(borrower);
		}
	}
	
	private void validateData(String ssn) {
		if (repository.findBySsn(ssn).isPresent()) {
			throw new DuplicatedBorrowerException(ssn);
		}
	}

}
