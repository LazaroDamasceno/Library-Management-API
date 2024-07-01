package com.api.v1.book.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.api.v1.book.Book;

public interface FindAllBooksService {
    
    CompletableFuture<List<Book>> findAll();

}
