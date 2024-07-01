package com.api.v1.book.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.v1.book.Book;
import com.api.v1.book.BookRepository;

@Service
public class FindAllBooksServiceImpl implements FindAllBooksService {

    private final BookRepository repository;

    public FindAllBooksServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    @Async
    public CompletableFuture<List<Book>> findAll() {
        return CompletableFuture.completedFuture(repository.findAll());
    }
    
}
