package com.api.v1.borrower;

import java.time.LocalDate;
import java.util.Optional;

import com.api.v1.borrower.self_register.SelfRegisterBorrowerDTO;

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

    private BorrowerBuilderImpl(
        String firstName, 
        Optional<String> middleName,
        String lastName, 
        String ssn, 
        LocalDate birthDate,
        String email, 
        String address, 
        String gender, 
        String phoneNumber
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    private BorrowerBuilderImpl(
        String firstName, 
        String lastName, 
        String ssn, 
        LocalDate birthDate,
        String email, 
        String address, 
        String gender, 
        String phoneNumber
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public BorrowerBuilderImpl() {

    }

    @Override
    public BorrowerBuilderImpl create(SelfRegisterBorrowerDTO dto) {
        return new BorrowerBuilderImpl(
            firstName,
            lastName,
            ssn,
            birthDate,
            email,
            address,
            gender,
            phoneNumber
    );}

    @Override
    public BorrowerBuilderImpl withMiddleName(String middleName) {
        return new BorrowerBuilderImpl(
            firstName,
            Optional.of(middleName),
            lastName,
            ssn,
            birthDate,
            email,
            address,
            gender,
            phoneNumber
    );}

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
    );}

}
