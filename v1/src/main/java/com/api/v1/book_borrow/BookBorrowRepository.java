package com.api.v1.book_borrow;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, UUID> {

    @Query("""
        select count(b) 
        from BookBorrow b 
        where b.borrower.ssn = :ssn
    """)
    long countHowManyBorrowsByBorrower(@Param("ssn") String ssn);  

    @Query("""
        select b 
        from Borrow b
        where b.book.isbn = :isbn
        and b.borrower.ssn = :ssn 
    """)
    Optional<BookBorrow> findBookBorrowByBookAndBorrower(@Param("isbn") UUID isbn, @Param("ssn") String ssn);
}
