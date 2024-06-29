package com.api.v1.borrower;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.api.v1.borrower.self_register.SelfRegisterBorrowerDTO;

@Service
public class BorrowerBuilderImpl implements  BorrowerBuilder {

    private final String firstName;
    private String middleName;
    private final String lastName;
    private final String ssn;
    private final LocalDate birthDate;
    private final String email;
    private final String address;
    private final String gender;
    private final String phoneNumber;

    private BorrowerBuilderImpl(
        String firstName, 
        String middleName, 
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
            middleName,
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
            middleName,
            lastName,
            ssn,
            birthDate,
            email,
            address,
            gender,
            phoneNumber
    );}

}
