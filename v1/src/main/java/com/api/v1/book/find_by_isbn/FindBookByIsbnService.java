package com.api.v1.book.find_by_isbn;

import com.api.v1.book.Book;

public interface FindBookByIsbnService {
    
    Book findByISBN(String isbn);

}
