package com.api.v1.book.delete;

import com.api.v1.customized_annotations.ISBN;

public interface DeleteBookByIsbnService {
    
    void delete(@ISBN String isbn);

}
