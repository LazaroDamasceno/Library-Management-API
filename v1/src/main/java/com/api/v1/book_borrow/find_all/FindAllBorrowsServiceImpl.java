package com.api.v1.book_borrow.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;

@Service
public class FindAllBorrowsServiceImpl implements FindAllBorrowsService {

    private final BookBorrowRepository repository;

    public FindAllBorrowsServiceImpl(BookBorrowRepository repository) {
        this.repository = repository;
    }

    @Override
    @Async
    public CompletableFuture<List<BookBorrow>> findAll() {
        return CompletableFuture.completedFuture(repository.findAll());
    }
    
}
