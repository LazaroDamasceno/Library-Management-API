package com.api.v1.borrower.update;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface UpdateBorrowerDataService {

	void updateData(@NotNull @Size(min = 9, max = 9 ) String ssn, @NotNull UpdateBorrowerDataDTO dto);
	
}
