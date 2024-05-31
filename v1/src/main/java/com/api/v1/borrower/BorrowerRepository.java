package com.api.v1.borrower;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.v1.customized_annotations.SSN;

public interface BorrowerRepository extends JpaRepository<Borrower, UUID> {
	
	Optional<Borrower> findBySsn(@SSN String ssn);

}
