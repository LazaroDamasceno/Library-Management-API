package com.api.v1.book;

public class DuplicatedBookException extends RuntimeException {
    
    public DuplicatedBookException(String isbn) {
        super("Book which ISBN is %s already exist.".formatted(isbn));
    }

}
