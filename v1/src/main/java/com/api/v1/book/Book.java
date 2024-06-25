package com.api.v1.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "v1_book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subtitle;

    @Column(nullable = false)
    private List<String> authors = new ArrayList<>();

    @Column(nullable = false)
    private List<String> fields = new ArrayList<>();

    @Column(nullable = false)
    private int numberOfPages;

    @Column(nullable = false, unique = true)
    private final UUID isbn = UUID.randomUUID();

    @Column(nullable = false)
    private int version;

    @Column(nullable = false)
    private int numberOfCopies;

    protected Book() {
    }

    public Book(String title, String subtitle,
                List<String> authors,
                List<String> fields,
                int numberOfPages,
                int version,
                int numberOfCopies
    ) {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.fields = fields;
        this.numberOfPages = numberOfPages;
        this.version = version;
        this.numberOfCopies = numberOfCopies;
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

    public UUID getIsbn() {
        return isbn;
    }

    public int getVersion() {
        return version;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

}
