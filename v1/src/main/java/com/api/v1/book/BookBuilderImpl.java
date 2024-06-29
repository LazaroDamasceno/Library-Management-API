package com.api.v1.book;

import org.springframework.stereotype.Service;

import com.api.v1.book.register.RegisterBookDTO;

@Service
public class BookBuilderImpl implements BookBuilder {

    private final String title;
    private final String subtitle;
    private final String author;
    private final String field;
    private final int numberOfPages;
    private final int version;
    private final int numberOfCopies;

    private BookBuilderImpl(RegisterBookDTO dto) {
        this.title = dto.title();
        this.subtitle = dto.subtitle();
        this.numberOfPages = dto.numberOfPages();
        this.version = dto.version();
        this.numberOfCopies = dto.numberOfCopies();
        this.author = dto.author();
        this.field = dto.field();
    }

    @Override
    public BookBuilderImpl create(RegisterBookDTO dto) {
        return new BookBuilderImpl(dto);
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
