package com.api.v1.book.find_all;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.book.Book;
import com.api.v1.book.BookRepository;

@Service
public class FindAllBooksServiceImpl implements FindAllBooksService {

    @Autowired
    private BookRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return repository.findAll();
    }
    
}
