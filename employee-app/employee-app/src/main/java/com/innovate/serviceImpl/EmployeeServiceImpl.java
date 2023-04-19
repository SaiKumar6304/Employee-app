package com.innovate.serviceImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovate.Exceptions.BussinessException;
import com.innovate.dto.EmployeeDto;
import com.innovate.entity.Employee;
import com.innovate.entity.EmployeeTaxDetails;
import com.innovate.repository.EmployeeRepository;
import com.innovate.serviceI.EmployeeServiceI;

import net.bytebuddy.implementation.bytecode.Throw;
@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employee) {

		Employee savedEmployee = repository.save(mapper.map(employee, Employee.class));
		return mapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public Double getEmployeetaxdeductionforthecurrentfinancialyear(Long id) {
	Employee employee=	repository.findById(id).orElseThrow( ()->new BussinessException("employee with id: "+id+" not existed"));
		

	
	Double tax = 0.0;
	Double cess = 0.0;
	EmployeeTaxDetails employeetaxdetails=new EmployeeTaxDetails();
	
			EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
     LocalDate employeestartingdate = employeeDto.getDOJ();
     LocalDate employeeendingdate =LocalDate.now()  ;
     long totalemployeemonthsworking = ChronoUnit.MONTHS.between(employeestartingdate, employeeendingdate);
    	Double totalsalaryofemployee = employeeDto.getSalary() *  totalemployeemonthsworking ;

	if (totalsalaryofemployee > 250000 && totalsalaryofemployee<=500000) 
	{

		return tax = (totalsalaryofemployee-250000)*0.05;
		
	}
	else if (totalsalaryofemployee > 500000 && totalsalaryofemployee <= 1000000) 
	{
		return tax = 12500+(totalsalaryofemployee-500000)*0.1;
	}
	else if (totalsalaryofemployee > 1000000 ) 
	{

		return tax =112500+(totalsalaryofemployee-1000000)*0.2 ;
	}

	
	if(totalsalaryofemployee>2500000) {
		return cess=(totalsalaryofemployee-2500000)*0.02;
	}
	double employeetotaltax =tax+cess;
	employeetaxdetails.setEmployeeID(employeeDto.getEmployeeID());
	employeetaxdetails.setFirstName(employeeDto.getFirstname());
	employeetaxdetails.setLastName(employeeDto.getLastname());
	employeetaxdetails.setEmail(employeeDto.getEmail());
	employeetaxdetails.setPhoneNumber(employeeDto.getPhonenumber());
	employeetaxdetails.setDOJ(employeeDto.getDOJ());
	employeetaxdetails.setSalary(employeeDto.getSalary());
	employeetaxdetails.setTotalTexAmount(tax);
	employeetaxdetails.setTotalCessAmount(cess);
	
	return employeetotaltax; 

	
	
	

	}

}
