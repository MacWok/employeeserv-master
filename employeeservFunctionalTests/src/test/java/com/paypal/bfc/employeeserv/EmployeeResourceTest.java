package com.paypal.bfc.employeeserv;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.EmployeeServiceException;
import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)  
public class EmployeeResourceTest {

	@InjectMocks
	EmployeeResourceImpl empResource;
	
	@Mock
	EmployeeService employeeService;
	
	@Test
	public void employeeGetByIdTest() {
		empResource.employeeGetById("1");
		when(employeeService.getEmployee(1)).thenReturn(new Employee());
	}
	
	@Test(expected=EmployeeServiceException.class)
	public void employeeGetByInvalidIdTest() {
		empResource.employeeGetById("abc");
	}
}
