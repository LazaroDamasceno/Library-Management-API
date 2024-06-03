package com.api.v1.book.find_by_isbn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.BookRepository;
import com.api.v1.customized_annotations.ISBN;

@Service
public class FindBookByIsbnServiceImpl implements FindBookByIsbnService {

    @Autowired
    private BookRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Book findByIsbn(@ISBN String isbn) {
        Optional<Book> book = repository.findByIsbn(isbn);
        if (book.isEmpty()) throw new BookNotFoundException(isbn);
        return book.get();
    }
    
}
