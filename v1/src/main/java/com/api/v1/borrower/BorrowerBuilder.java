package com.api.v1.borrower;

import java.time.LocalDate;

public class BorrowerBuilder {

    private final String firstName;
    private String middleName;
    private final String lastName;
    private final String ssn;
    private final LocalDate birthDate;
    private final String email;
    private final String address;
    private final String gender;
    private final String phoneNumber;

    BorrowerBuilder(
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

    public BorrowerBuilder(
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

    public BorrowerBuilder middleName(String middleName) {
        return new BorrowerBuilder(
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

    public Borrower build() {
        if (middleName == null) {
            return new Borrower(
                firstName,
                lastName,
                ssn,
                birthDate,
                email,
                address,
                gender,
                phoneNumber
        );}
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
