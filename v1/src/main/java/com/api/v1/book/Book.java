package com.api.v1.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.api.v1.book.register.RegisterBookDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "v1_book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title = "";

    @Column(nullable = false)
    private String subtitle = "";

    @Column(nullable = false)
    private List<String> authors = new ArrayList<>();

    @Column(nullable = false)
    private List<String> fields = new ArrayList<>();

    @Column(nullable = false)
    private int numberOfPages = 0;

    @Column(nullable = false, unique = true)
    private String isbn = "";

    @Column(nullable = false)
    private int vesion = 1;

    @Column(nullable = false)
    private int numberOfCopies = 0;

    @Column(nullable = false)
    private int numberOfBorrowedCopies = 0;

    private Book(RegisterBookDTO dto) {
        this.title = dto.title();
        this.subtitle = dto.subtitle();
        this.authors.add(dto.authorsDTO().firstAuthor());
        this.authors.add(dto.authorsDTO().secondAuthor());
        this.authors.add(dto.authorsDTO().thirdAuthor());
        this.fields.add(dto.fieldsDTO().mainField());
        this.fields.add(dto.fieldsDTO().secondaryField());
        this.fields.add(dto.fieldsDTO().ternaryField());
        this.numberOfPages = dto.numberOfPages();
        this.isbn = dto.isbn();
        this.vesion = dto.vesion();
    }

    public static Book createInstance(RegisterBookDTO dto) {
        return new Book(dto);
    }

    public Book() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<String> getFields() {
        return fields;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getVesion() {
        return vesion;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public int getNumberOfBorrowedCopies() {
        return numberOfBorrowedCopies;
    }
    
}
