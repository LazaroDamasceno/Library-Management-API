package com.api.v1.book.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.customized_annotations.ISBN;

@RestController
@RequestMapping("api/v1/books")
public class DeleteBookByIsbnController {
    
    @Autowired
    private DeleteBookByIsbnService service;

    @DeleteMapping("{isbn}")
    public ResponseEntity<Void> delete(@ISBN String isbn) {
        service.delete(isbn);
        return ResponseEntity.status(204).build();
    }

}
