package com.api.v1.system_user;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v1_system_user")
@Getter
@Setter
@NoArgsConstructor
public class SystemUser implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @Column(nullable = false, unique = true)
    private String ssn;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String phoneNumber;

    public SystemUser(RegisterSystemUserDTO dto) {
        this.fullName = dto.fullName();
        this.birthDate = dto.birthDate();
        this.ssn = dto.ssn();
        this.email = dto.email();
        this.gender = dto.gender();
        this.phoneNumber = dto.phoneNumber();
    }

    public void update(UpdateSystemUserDTO dto) {
        this.fullName = dto.fullName();
        this.birthDate = dto.birthDate();
        this.email = dto.email();
        this.gender = dto.gender();
        this.phoneNumber = dto.phoneNumber();
    }

}
