package com.paypal.bfs.test.employeeserv.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Getter
	@Setter
	private String firstName;
	
	@Getter
	@Setter
	private String lastName;
	
	@Getter
	@Setter
	private LocalDate dob;
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="address", nullable=false)
	private AddressEntity address;
	
	
	
	public EmployeeEntity(Employee employee) {
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.dob = employee.getDob();
		if(employee.getId() != null) {
			this.id = employee.getId();
		}
		this.address = new AddressEntity(employee.getAddress());
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setDob(dob);
		employee.setId(id);
		employee.setAddress(address.getAddress());
		return employee;
	}
	
	
	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public EmployeeEntity() {
		super();
	}
	
	
	
}
