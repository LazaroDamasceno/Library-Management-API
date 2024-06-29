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
		Borrower borrower = createBorrower(dto);
		repository.save(borrower);
	}

	private Borrower createBorrower(SelfRegisterBorrowerDTO dto) {
		if (dto.middleName() == null) return builder.create(dto).build();
		return builder.create(dto).withMiddleName(dto.middleName()).build();
	}
	
	private void validateData(String ssn) {
		if (repository.findBySsn(ssn).isPresent()) {
			throw new DuplicatedBorrowerException(ssn);
		}
	}

}
