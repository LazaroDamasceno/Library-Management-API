package com.api.v1.book.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.BookRepository;
import com.api.v1.book.find_by_isbn.FindBookByIsbnService;

@Service
public class DeleteBookByIsbnServiceImpl implements DeleteBookByIsbnService {

    @Autowired
    private FindBookByIsbnService findBookByISBN;

    @Autowired
    private BookRepository repository;

    @Override
    @Transactional
    public void delete(String isbn) {
        Book book = findBookByISBN.findByISBN(isbn);
        repository.delete(book);
    }
    
}
