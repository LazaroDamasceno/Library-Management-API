package com.api.v1.book;

import com.api.v1.book.register.RegisterBookDTO;

public interface BookBuilder {
    
    BookBuilderImpl createFromDTO(RegisterBookDTO dto);
    Book build();

}
