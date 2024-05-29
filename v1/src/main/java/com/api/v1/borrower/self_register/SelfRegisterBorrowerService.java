package com.api.v1.borrower.self_register;

import jakarta.validation.constraints.NotNull;

public interface SelfRegisterBorrowerService {
	
	void selfRegister(@NotNull SelfRegisterBorrowerDTO dto);

}
