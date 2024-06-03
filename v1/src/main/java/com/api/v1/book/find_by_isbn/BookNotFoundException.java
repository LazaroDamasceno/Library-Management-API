package com.api.v1.book.find_by_isbn;

public class BookNotFoundException extends RuntimeException {
    
    public BookNotFoundException(String isbn) {
        super("Book which ISBN is %s was not found.".formatted(isbn));
    }

}
