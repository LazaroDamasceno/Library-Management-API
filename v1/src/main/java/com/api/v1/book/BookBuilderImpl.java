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
