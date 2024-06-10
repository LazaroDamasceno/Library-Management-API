package com.api.v1.book_borrow.find_all;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;

@Service
public class FindAllBorrowsServiceImpl implements FindAllBorrowsService {

    @Autowired
    private BookBorrowRepository repository;

    @Override
    public List<BookBorrow> findAll() {
        return repository.findAll();
    }
    
}
