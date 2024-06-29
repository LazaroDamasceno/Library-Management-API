package com.api.v1.book;

import com.api.v1.book.register.RegisterBookDTO;

public class BookBuilderImpl implements BookBuilder {

    private String title;
    private String subtitle;
    private String author;
    private String field;
    private int numberOfPages;
    private int version;
    private int numberOfCopies;

    private BookBuilderImpl(
            String title,
            String subtitle,
            String author,
            String field,
            int numberOfPages,
            int version,
            int numberOfCopies
    ) {
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.field = field;
        this.numberOfPages = numberOfPages;
        this.version = version;
        this.numberOfCopies = numberOfCopies;
    }

    public BookBuilderImpl() {

    }

    @Override
    public BookBuilderImpl create(RegisterBookDTO dto) {
        return new BookBuilderImpl(
                dto.title(),
                dto.subtitle(),
                dto.author(),
                dto.field(),
                dto.numberOfPages(),
                dto.version(),
                dto.numberOfCopies()
        );
    }

    @Override
    public Book build() {
        return new Book(
                title,
                subtitle,
                author,
                field,
                numberOfPages,
                version,
                numberOfCopies
        );
    }

}
