package com.paypal.bfs.test.employeeserv.impl;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.paypal.bfs.test.employeeserv.exception.EmployeeServiceException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeeServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<String> handleException(Exception ex) {
		logger.info("exception {} ", ex);
		String bodyOfResponse = "Server error";
		return new ResponseEntity<>(bodyOfResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { DataIntegrityViolationException.class })
	protected ResponseEntity<String> handleException(DataIntegrityViolationException ex) {
		logger.info("ConstraintViolationException {} ", ex);
		String bodyOfResponse = "Employee information is already present in the system";
		return new ResponseEntity<>(bodyOfResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { EmployeeServiceException.class })
	protected ResponseEntity<String> handleException(EmployeeServiceException ex) {
		logger.info("EmployeeServiceException {} ", ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}