package com.api.v1.book.delete;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.BookRepository;
import com.api.v1.book.find_by_isbn.FindBookByIsbnService;

@Service
public class DeleteBookByIsbnServiceImpl implements DeleteBookByIsbnService {

    private final FindBookByIsbnService findBookByISBN;
    private final BookRepository repository;

    public DeleteBookByIsbnServiceImpl(FindBookByIsbnService findBookByISBN, BookRepository repository) {
        this.findBookByISBN = findBookByISBN;
        this.repository = repository;
    }

    @Override
    @Transactional
    public void delete(String isbn) {
        Book book = findBookByISBN.findByISBN(isbn);
        repository.delete(book);
    }
    
}
