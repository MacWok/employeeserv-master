package com.paypal.bfs.test.employeeserv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exception.EmployeeServiceException;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Integer addEmployee(Employee emp) {
		EmployeeEntity employeeEntity = new EmployeeEntity(emp);
		return employeeRepository.save(employeeEntity).getId();
	}
	
	public Employee getEmployee(Integer empId) {
		EmployeeEntity employeeEntity = employeeRepository.findById(empId).orElse(null);
		if(null == employeeEntity) {
			throw new EmployeeServiceException("No employee found with the given id");
		}else {
			return employeeEntity.getEmployee();
		}
	}
}
