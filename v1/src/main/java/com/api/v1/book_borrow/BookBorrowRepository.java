package com.api.v1.book_borrow;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, UUID> {
    
}
