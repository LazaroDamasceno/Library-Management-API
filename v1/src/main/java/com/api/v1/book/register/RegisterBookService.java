package com.api.v1.book.register;

import jakarta.validation.constraints.NotNull;

public interface RegisterBookService {

    void register(@NotNull RegisterBookDTO dto);
    
}
