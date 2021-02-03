package com.paypal.bfs.test.employeeserv.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.EmployeeServiceException;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;
	

	@Override
	public ResponseEntity<Employee> employeeGetById(String id) {
		Integer empId;
		try {
			empId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			throw new EmployeeServiceException("Invalid employee Id");
		}
		return new ResponseEntity<>(employeeService.getEmployee(empId), HttpStatus.OK);
	}
    
    @Override
    public ResponseEntity<Integer> createEmployee(Employee emp,  BindingResult result){
    	if(result.hasErrors()) {
    		List<String> messages = result.getFieldErrors().stream().map(error -> error.getField() + " - " + error.getDefaultMessage())
    				.collect(Collectors.toList());
    		throw new EmployeeServiceException(String.join(", " , messages ));
    	}
    	return new ResponseEntity<>(employeeService.addEmployee(emp), HttpStatus.OK);
    }
}
