package com.api.v1.borrower.find_all;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.BorrowerRepository;

@Service
public class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

	private final BorrowerRepository repository;
	
	public FindAllBorrowersServiceImpl(BorrowerRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Borrower> FindAll() {
		return repository.findAll();
	}

}
