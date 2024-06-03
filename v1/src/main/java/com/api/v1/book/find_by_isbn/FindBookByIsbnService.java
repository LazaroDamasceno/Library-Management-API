package com.api.v1.book.find_by_isbn;

import com.api.v1.book.Book;
import com.api.v1.customized_annotations.ISBN;

public interface FindBookByIsbnService {
    
    Book findByIsbn(@ISBN String isbn);

}
