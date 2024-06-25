package com.api.v1.borrower;

import com.api.v1.borrower.self_register.SelfRegisterBorrowerDTO;

import java.time.LocalDate;

public class BorrowerBuilder {

    private String firstName;
    private String middleName;
    private String lastName;
    private String ssn;
    private LocalDate birthDate;
    private String email;
    private String address;
    private String gender;
    private String phoneNumber;

    public BorrowerBuilder fromDto(SelfRegisterBorrowerDTO dto) {
        this.firstName = dto.firstName();
        this.middleName = dto.middleName();
        this.lastName = dto.lastName();
        this.ssn = dto.ssn();
        this.birthDate = dto.birthDate();
        this.email = dto.email();
        this.address = dto.address();
        this.gender = dto.gender();
        this.phoneNumber = dto.phoneNumber();
        return this;
    }

    public Borrower build() {
        return new Borrower(
                firstName,
                middleName,
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
