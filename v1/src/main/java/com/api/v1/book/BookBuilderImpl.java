package com.api.v1.book;

import org.springframework.stereotype.Service;

import com.api.v1.book.register.RegisterBookDTO;

@Service
public class BookBuilderImpl implements BookBuilder {

    private String title;
    private String subtitle;
    private String author;
    private String field;
    private int numberOfPages;
    private int version;
    private int numberOfCopies;

    @Override
    public BookBuilderImpl createFromDTO(RegisterBookDTO dto) {
        this.title = dto.title();
        this.subtitle = dto.subtitle();
        this.author = dto.author();
        this.field = dto.field();
        this.numberOfPages = dto.numberOfPages();
        this.version = dto.version();
        this.numberOfCopies = dto.numberOfCopies();
        return this;
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
