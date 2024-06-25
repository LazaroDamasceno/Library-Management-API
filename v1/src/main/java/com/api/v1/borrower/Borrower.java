package com.api.v1.borrower;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.api.v1.borrower.update.UpdateBorrowerDataDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "v1_borrower")
public class Borrower implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false)
    private String firstName;

	private String middleName;

	@Column(nullable = false)
	private String lastName;
    
    @Column(nullable = false, unique = true)
    private String ssn;
    
    @Column(nullable = false)
    private LocalDate birthDate;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String phoneNumber;

	protected Borrower() {
	}

	Borrower(
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

	public void updateData(UpdateBorrowerDataDTO dto) {
		this.firstName = dto.firstName();
		this.middleName = dto.middleName();
		this.lastName = dto.lastName();
		this.birthDate = dto.birthDate();
		this.email = dto.email();
		this.address = dto.address();
		this.gender = dto.gender();
		this.phoneNumber = dto.phoneNumber();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getSsn() {
		return ssn;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getFirstName() {
		return firstName;
	}

}