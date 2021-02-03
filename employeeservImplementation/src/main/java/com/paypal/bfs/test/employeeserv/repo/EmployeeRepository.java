package com.paypal.bfs.test.employeeserv.repo;

import org.springframework.data.repository.CrudRepository;

import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer>{
	EmployeeEntity findById(long id);
}
