
package com.paypal.bfc.employeeserv;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.AddressEntity;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exception.EmployeeServiceException;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	EmployeeRepository employeeRepository;

	@InjectMocks
	EmployeeService employeeService;

	@Test
	public void addEmployeeTest() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setAddress(new AddressEntity());
		entity.setId(1);
		when(employeeRepository.save(anyObject())).thenReturn(entity);
		Employee emp = new Employee();
		emp.setAddress(new Address());
		int id = employeeService.addEmployee(emp);
		assertEquals(1, id);
	}

	@Test
	public void getEmployeeTest() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setAddress(new AddressEntity());
		entity.setId(1);
		when(employeeRepository.findById(anyObject())).thenReturn(Optional.of(entity));
		Employee emp = employeeService.getEmployee(1);
		assertEquals(1, (int) emp.getId());
	}
	
	@Test(expected=EmployeeServiceException.class)
	public void getEmployeeNotExistTest() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setAddress(new AddressEntity());
		entity.setId(1);
		when(employeeRepository.findById(anyObject())).thenReturn(Optional.ofNullable(null));
		employeeService.getEmployee(2);
	}
}
