package com.api.v1.book;

import com.api.v1.book.register.RegisterBookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookBuilder {

    private String title;
    private String subtitle;
    private List<String> authors = new ArrayList<>();
    private List<String> fields = new ArrayList<>();
    private int numberOfPages;
    private int version;
    private int numberOfCopies;

    public BookBuilder fromDto(RegisterBookDTO dto) {
        this.title = dto.title();
        this.subtitle = dto.subtitle();
        this.authors.add(dto.authorsDTO().firstAuthor());
        this.authors.add(dto.authorsDTO().secondAuthor());
        this.authors.add(dto.authorsDTO().thirdAuthor());
        this.fields.add(dto.fieldsDTO().mainField());
        this.fields.add(dto.fieldsDTO().secondaryField());
        this.fields.add(dto.fieldsDTO().ternaryField());
        this.numberOfPages = dto.numberOfPages();
        this.version = dto.version();
        this.numberOfCopies = dto.numberOfCopies();
        return this;
    }

    public Book build() {
        return new Book(
                title,
                subtitle,
                authors,
                fields,
                numberOfPages,
                version,
                numberOfCopies
        );
    }

}
