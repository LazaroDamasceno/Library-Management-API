package com.api.v1.borrow;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

import com.api.v1.book.Book;
import com.api.v1.borrower.Borrower;

import jakarta.persistence.*;

@Entity
@Table(name = "v1_borrow")
public class Borrow implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private final ZonedDateTime borrowingDateTime = ZonedDateTime.now();

    @Column(nullable = false)
    private final ZonedDateTime excepetedReturningDateTime = ZonedDateTime.now();

    private ZonedDateTime extendedReturningDateTime;

    private ZonedDateTime returnedDateTime;

    @Column(nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    @Column(nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Borrower borrower;

    protected Borrow() {
    }

    private Borrow(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
    }

    public static Borrow createInstance(Book book, Borrower borrower) {
        return new Borrow(book, borrower);
    }

    public void renewBorrow() {
        this.extendedReturningDateTime = excepetedReturningDateTime.plusWeeks(2);
    }

    public void returnBook () {
        this.returnedDateTime = ZonedDateTime.now();
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

    public ZonedDateTime getExcepetedReturningDateTime() {
        return excepetedReturningDateTime;
    }

    public ZonedDateTime getExtendedReturningDateTime() {
        return extendedReturningDateTime;
    }

    public ZonedDateTime getReturnedDateTime() {
        return returnedDateTime;
    }

    public Book getBook() {
        return book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

}
