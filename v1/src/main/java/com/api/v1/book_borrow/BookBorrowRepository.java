package com.api.v1.book_borrow;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, UUID> {

    @Query("""
        SELECT bb
        FROM BookBorrow bb
        WHERE bb.book = :book
        AND bb.borrower = :borrower
    """)
    Optional<BookBorrow> findBookBorrowByBookAndBorrower(@Param("book") Book book, @Param("borrower") Borrower borrower);

    @Query("""
        SELECT bb 
        FROM BookBorrow bb
        WHERE bb.borrower = :borrower
    """)
    List<BookBorrow> findAllBookBorrowsByBorrowers(@Param("borrower") Borrower borrower);

    @Query("""
        SELECT bb
        FROM BookBorrow bb
        WHERE bb.borrower = :borrower
        AND bb.borrowDateTime >= firstDateTime
        AND bb.borrowDateTime <= lastDateTime
    """)
    List<BookBorrow> findBookBorrowsByBorrowersBetweenDateTimes(
        @Param("borrower") Borrower borrower,
        @Param("firstDateTime") LocalDateTime firstDateTime,
        @Param("lastDateTime") LocalDateTime lastDateTime
    );

    @Query("""
        SELECT bb
        FROM BookBorrow bb
        WHERE bb.borrower = :borrower
        AND (
            bb.actualReturnDateTime IS NULL
            OR bb.dueDateTime <= CURRENT_TIMESTAMP
            OR (
                bb.extendedDueDateTime IS NOT NULL
                AND bb.extendedDueDateTime <= CURRENT_TIMESTAMP
            )
        )
    """)
    List<BookBorrow> findActiveBookBorrowsByBorrowers(@Param("borrower") Borrower borrower);
    

}
