package com.api.v1.book_borrow.find_all;

import java.util.List;

import com.api.v1.book_borrow.BookBorrow;

public interface FindAllBorrowsService {

    List<BookBorrow> findAll();
    
}
