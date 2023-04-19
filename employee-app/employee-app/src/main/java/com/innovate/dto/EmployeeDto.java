package com.innovate.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeDto {
	private Long EmployeeID;
	@NotNull(message = " required firstname ")
	private String firstname;
	@NotNull(message = " required lastname")
	private String lastname;
	@Email(message = "Email is not valid")
	@NotNull(message = " required Email")
	private String email;
	@NotBlank(message = "required Phone no  ")
	private String phonenumber;
	@NotNull(message = " required Date of joining ")
	private LocalDate DOJ;
	private Double salary;
	

	public EmployeeDto() {

	}


	public EmployeeDto(Long employeeID, @NotNull(message = " required firstname ") String firstname,
			@NotNull(message = " required lastname") String lastname,
			@Email(message = "Email is not valid") @NotNull(message = " required Email") String email,
			@NotBlank(message = "required Phone no  ") String phonenumber,
			@NotNull(message = " required Date of joining ") LocalDate dOJ, Double salary) {
		super();
		EmployeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		DOJ = dOJ;
		this.salary = salary;
	}


	public Long getEmployeeID() {
		return EmployeeID;
	}


	public void setEmployeeID(Long employeeID) {
		EmployeeID = employeeID;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public LocalDate getDOJ() {
		return DOJ;
	}


	public void setDOJ(LocalDate dOJ) {
		DOJ = dOJ;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "EmployeeDto [EmployeeID=" + EmployeeID + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", DOJ=" + DOJ + ", salary=" + salary + "]";
	}


	
	
}