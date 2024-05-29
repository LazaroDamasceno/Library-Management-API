package com.api.v1.borrower;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.api.v1.borrower.self_register.SelfRegisterBorrowerDTO;
import com.api.v1.borrower.update.UpdateBorrowerDataDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "v1_borrower")
public class Borrower implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false)
    private String name;
    
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
    
	public Borrower() {
		super();
	}
	
	private Borrower(SelfRegisterBorrowerDTO dto) {
		super();
		this.name = dto.name();
		this.ssn = dto.ssn();
		this.birthDate = dto.birthDate();
		this.email = dto.email();
		this.address = dto.address();
		this.gender = dto.gender();
		this.phoneNumber = dto.phoneNumber();
	}
	
	public static Borrower createInstance(SelfRegisterBorrowerDTO dto) {
		return new Borrower(dto);
	}
	
	public void updateData(UpdateBorrowerDataDTO dto) {
		this.name = dto.name();
		this.birthDate = dto.birthDate();
		this.email = dto.email();
		this.address = dto.address();
		this.gender = dto.gender();
		this.phoneNumber = dto.phoneNumber();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSsn() {
		return ssn;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getGender() {
		return gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
    
}