package com.paypal.bfc.employeeserv;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;

import com.paypal.bfs.test.employeeserv.exception.EmployeeServiceException;
import com.paypal.bfs.test.employeeserv.impl.EmployeeServiceExceptionHandler;


public class EmployeeServiceExceptionHandlerTest extends EmployeeServiceExceptionHandler{

	
	@Test
	public void handleDataIntegrityViolationExceptionTest() {
		ResponseEntity<String> resp = handleException(new DataIntegrityViolationException("test violation exception"));
		assertEquals("Employee information is already present in the system", resp.getBody());
		assertEquals(400,resp.getStatusCodeValue());
		
	}
	
	@Test
	public void handleEmployeeServiceExceptionTest() {
		ResponseEntity<String> resp = handleException(new EmployeeServiceException("address can not be null"));
		assertEquals("address can not be null", resp.getBody());
		assertEquals(400,resp.getStatusCodeValue());
		
	}
	
	@Test
	public void handleExceptionTest() {
		ResponseEntity<String> resp = handleException(new RuntimeException("Other exception"));
		assertEquals("Server error", resp.getBody());
		assertEquals(500,resp.getStatusCodeValue());
		
	}
}
