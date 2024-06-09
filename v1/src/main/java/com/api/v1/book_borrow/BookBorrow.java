package com.api.v1.book_borrow;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;

import jakarta.persistence.*;

@Entity
@Table(name = "v1_borrow")
public class BookBorrow implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private final ZonedDateTime borrowingDateTime = ZonedDateTime.now();

    @Column(nullable = false)
    private final ZonedDateTime dueDateTime = ZonedDateTime.now();

    private ZonedDateTime extendedDueDateTime;

    private ZonedDateTime actualReturnDateTime;

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
        this.actualReturnDateTime = ZonedDateTime.now();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public ZonedDateTime getBorrowingDateTime() {
        return borrowingDateTime;
    }

    public ZonedDateTime getDueDateTime() {
        return dueDateTime;
    }

    public ZonedDateTime getExtendedDueDateTime() {
        return extendedDueDateTime;
    }

    public ZonedDateTime getActualReturnDateTime() {
        return actualReturnDateTime;
    }

    public Book getBook() {
        return book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

}
