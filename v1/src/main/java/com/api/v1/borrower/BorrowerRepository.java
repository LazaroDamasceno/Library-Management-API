package com.api.v1.borrower;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface BorrowerRepository extends JpaRepository<Borrower, UUID> {
	
	Optional<Borrower> findBySsn(@NotNull @Size(min = 9, max = 9) String ssn);

}
