package com.api.v1.book.find_by_isbn;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.BookRepository;

@Service
public class FindBookByIsbnServiceImpl implements FindBookByIsbnService {

    private final BookRepository repository;

    public FindBookByIsbnServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Book findByISBN(String isbn) {
        Optional<Book> book = repository.findByIsbn(UUID.fromString(isbn));
        if (book.isEmpty()) throw new BookNotFoundException(isbn);
        return book.get();
    }
    
}
