package com.api.v1.book_borrow;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;

import jakarta.persistence.*;

@Entity
@Table(name = "v1_book_borrow")
public class BookBorrow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private final LocalDateTime borrowDateTime = LocalDateTime.now();

    @Column(nullable = false)
    private final LocalDateTime dueDateTime = LocalDateTime.now().plusWeeks(2);

    private LocalDateTime extendedDueDateTime;

    private LocalDateTime actualReturnDateTime;

    @Column(nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    @Column(nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Borrower borrower;

    protected BookBorrow() {
    }

    private BookBorrow(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
    }

    public static BookBorrow createInstance(Book book, Borrower borrower) {
        return new BookBorrow(book, borrower);
    }

    public void renewBorrow() {
        this.extendedDueDateTime = dueDateTime.plusWeeks(2);
    }

    public void markAsReturned () {
        this.actualReturnDateTime = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getBorrowDateTime() {
        return borrowDateTime;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public LocalDateTime getExtendedDueDateTime() {
        return extendedDueDateTime;
    }

    public LocalDateTime getActualReturnDateTime() {
        return actualReturnDateTime;
    }

    public Book getBook() {
        return book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

}
