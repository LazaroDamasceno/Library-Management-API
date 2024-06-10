package com.api.v1.book_borrow.find_all;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;

@Service
public class FindAllBorrowsServiceImpl implements FindAllBorrowsService {

    private final BookBorrowRepository repository;

    public FindAllBorrowsServiceImpl(BookBorrowRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookBorrow> findAll() {
        return repository.findAll();
    }
    
}
