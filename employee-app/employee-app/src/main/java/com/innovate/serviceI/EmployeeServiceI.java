package com.innovate.serviceI;

import com.innovate.dto.EmployeeDto;

public interface EmployeeServiceI {

	EmployeeDto saveEmployee(EmployeeDto employee);

	Double getEmployeetaxdeductionforthecurrentfinancialyear(Long id);

}
