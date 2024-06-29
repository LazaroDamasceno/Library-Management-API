package com.api.v1.book;

import com.api.v1.book.register.RegisterBookDTO;

public interface BookBuilder {
    
    BookBuilderImpl create(RegisterBookDTO dto);
    Book build();

}
