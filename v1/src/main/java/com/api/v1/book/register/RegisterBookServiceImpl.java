package com.api.v1.book.register;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.BookRepository;
import com.api.v1.book.DuplicatedBookException;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterBookServiceImpl implements RegisterBookService {

    private final BookRepository repository;

    @Override
    @Transactional
    public void register(@NotNull RegisterBookDTO dto) {
        isBookAlreadyRegistered(dto.isbn());
        Book book = Book.createInstance(dto);
        repository.save(book);
    }

    private void isBookAlreadyRegistered(String isbn) {
        if (repository.findByIsbn(isbn).isPresent()) {
            throw new DuplicatedBookException(isbn);
        }
    }
    
}
