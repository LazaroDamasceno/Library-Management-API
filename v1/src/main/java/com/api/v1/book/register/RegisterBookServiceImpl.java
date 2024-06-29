package com.api.v1.book.register;

import com.api.v1.book.BookBuilderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.BookRepository;

import jakarta.validation.constraints.NotNull;

@Service
public class RegisterBookServiceImpl implements RegisterBookService {

    private final BookRepository repository;

    public RegisterBookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void register(@NotNull RegisterBookDTO dto) {
        Book book = new BookBuilderImpl().create(dto).build();
        repository.save(book);
    }
    
}
