package com.innovate.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovate.dto.EmployeeDto;
import com.innovate.serviceI.EmployeeServiceI;

@RestController
@RequestMapping(value = "api/innovate/a1")

public class EmployeeController {

	@Autowired
	private EmployeeServiceI service;

	@PostMapping(value = "/employee")
	public ResponseEntity<?> createEmployee(@Validated @RequestBody EmployeeDto employee, BindingResult binder) {
System.out.println(".............."+employee.getDOJ());

		if (binder.hasErrors()) {
			Map<String, String> validationsMap = new HashMap<String, String>();
			for (FieldError error : binder.getFieldErrors()) {
				validationsMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(validationsMap, HttpStatus.BAD_REQUEST);

		} else {

		
			return new ResponseEntity<EmployeeDto>(service.saveEmployee(employee), HttpStatus.CREATED);
		}
	}

	@GetMapping("/employeetax/{id}")
	public ResponseEntity<?> getEmployeeTaxDeductionCurrentFinancialYear(@PathVariable("id") Long id) {

		return new ResponseEntity<Double>(service.getEmployeetaxdeductionforthecurrentfinancialyear(id), HttpStatus.OK);

	}

}
