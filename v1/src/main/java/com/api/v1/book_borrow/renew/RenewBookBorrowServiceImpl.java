package com.api.v1.book_borrow.renew;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.book_borrow.BookBorrowRepository;
import com.api.v1.book_borrow.find_by_book_and_borrower.FindBookBorrowByBookAndBorrowerService;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class RenewBookBorrowServiceImpl implements RenewBookBorrowService {

    private final FindBookBorrowByBookAndBorrowerService findBookBorrowByBookAndBorrower;
    private final BookBorrowRepository repository;

    public RenewBookBorrowServiceImpl(FindBookBorrowByBookAndBorrowerService findBookBorrowByBookAndBorrower,
                                      BookBorrowRepository repository)
    {
        this.findBookBorrowByBookAndBorrower = findBookBorrowByBookAndBorrower;
        this.repository = repository;
    }

    @Override
    @Transactional
    public void RenewByBorrower(@NotNull BookBorrowDataDTO dto) {
        BookBorrow borrow = findBookBorrowByBookAndBorrower.findByBookAndBorrower(dto.isbn(), dto.ssn());
        validate(borrow);
        borrow.renewBorrow();
        repository.save(borrow);
    }

    private void validate(BookBorrow borrow) {
        UUID isbn = borrow.getBook().getIsbn();
        String ssn = borrow.getBorrower().getSsn();
        if (borrow.getExtendedDueDateTime() != null) {
            throw new BookRenewLimitReachedException(borrow.getDueDateTime(), isbn, ssn);
        }
    }

}
