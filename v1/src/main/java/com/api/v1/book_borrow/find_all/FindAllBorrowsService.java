package com.api.v1.book_borrow.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.api.v1.book_borrow.BookBorrow;

public interface FindAllBorrowsService {

    CompletableFuture<List<BookBorrow>> findAll();
    
}
