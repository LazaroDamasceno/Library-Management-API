package com.api.v1.borrower.self_register;

import com.api.v1.borrower.BorrowerBuilderImpl;
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
		Borrower borrower = createBorrower(dto);
		repository.save(borrower);
	}

	private Borrower createBorrower(SelfRegisterBorrowerDTO dto) {
		if (dto.middleName() == null) new BorrowerBuilderImpl().create(dto).build();
		return new BorrowerBuilderImpl().create(dto).withMiddleName(dto.middleName()).build();
	}
	
	private void validateData(String ssn) {
		if (repository.findBySsn(ssn).isPresent()) {
			throw new DuplicatedBorrowerException(ssn);
		}
	}

}
