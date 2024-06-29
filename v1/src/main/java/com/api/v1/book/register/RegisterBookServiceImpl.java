package com.api.v1.book.register;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.BookBuilder;
import com.api.v1.book.BookRepository;

import jakarta.validation.constraints.NotNull;

@Service
public class RegisterBookServiceImpl implements RegisterBookService {

    private final BookRepository repository;
    private final BookBuilder builder;

    public RegisterBookServiceImpl(BookBuilder builder, BookRepository repository) {
        this.builder = builder;
        this.repository = repository;
    }

    @Override
    @Transactional
    public void register(@NotNull RegisterBookDTO dto) {
        Book book = builder.create(dto).build();
        repository.save(book);
    }
    
}
