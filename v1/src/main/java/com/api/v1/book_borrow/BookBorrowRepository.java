package com.api.v1.book_borrow;

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
    List<BookBorrow> findAllBookBorrowsByBorrower(@Param("borrower") Borrower borrower);

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
    List<BookBorrow> findActiveBookBorrowsByBorrower(@Param("borrower") Borrower borrower);
    
    @Query("""
        SELECT bb
        FROM BookBorrow bb
        WHERE bb.borrower = :borrower
        AND (
            bb.actualReturnDateTime IS NULL
            OR bb.dueDateTime < CURRENT_TIMESTAMP
            OR (
                bb.extendedDueDateTime IS NOT NULL
                AND bb.extendedDueDateTime < CURRENT_TIMESTAMP
            )
        )
    """)
    List<BookBorrow> findOverdueBookBorrowsByBorrower(@Param("borrower") Borrower borrower);

    @Query("""
        SELECT bb
        FROM BookBorrow bb
        WHERE bb.borrower = :borrower
        AND bb.actualReturnDateTime IS NOT NULL
    """)
    List<BookBorrow> findFinishedBookBorrowsByBorrower(@Param("borrower") Borrower borrower);

    @Query(
        """
            SELECT COUNT(bb) 
            FROM BookBorrow bb    
            WHERE bb.borrower = :borrower    
        """
    )
    int countHowManyBorrowsByBorrower(@Param("borrower") Borrower borrower);

}
