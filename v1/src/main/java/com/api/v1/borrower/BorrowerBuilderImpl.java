package com.api.v1.borrower;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.borrower.self_register.SelfRegisterBorrowerDTO;

@Service
public class BorrowerBuilderImpl implements BorrowerBuilder {

    private String firstName;
    private Optional<String> middleName;
    private String lastName;
    private String ssn;
    private LocalDate birthDate;
    private String email;
    private String address;
    private String gender;
    private String phoneNumber;

    @Override
    public BorrowerBuilderImpl createFromDTO(SelfRegisterBorrowerDTO dto) {
        this.firstName = dto.firstName();
        this.lastName = dto.lastName();
        this.ssn = dto.ssn();
        this.birthDate = dto.birthDate();
        this.email = dto.email();
        this.address = dto.address();
        this.gender = dto.gender();
        this.phoneNumber = dto.phoneNumber();
        return this;
    }

    @Override
    public BorrowerBuilderImpl withMiddleName(String middleName) {
        this.middleName = Optional.of(middleName);
        return this;
    }

    @Override
    public Borrower build() {
        return new Borrower(
            firstName,
            middleName.orElse(null),
            lastName,
            ssn,
            birthDate,
            email,
            address,
            gender,
            phoneNumber
        );
    }

}
