package com.api.v1.book.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class RegisterBookController {
    
    private final RegisterBookService service;

    @PostMapping
    public ResponseEntity<Void> register(@NotNull @RequestBody RegisterBookDTO dto) {
        service.register(dto);
        return ResponseEntity.status(201).build();
    }

}
