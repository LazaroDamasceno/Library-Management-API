package com.api.v1.borrower.find_all;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.borrower.Borrower;
import com.api.v1.borrower.BorrowerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

	private final BorrowerRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Borrower> FindAll() {
		return repository.findAll();
	}

}
