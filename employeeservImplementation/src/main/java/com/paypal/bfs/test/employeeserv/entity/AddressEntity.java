package com.paypal.bfs.test.employeeserv.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.paypal.bfs.test.employeeserv.api.model.Address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
public class AddressEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private Integer id;
	
	
	@Getter
	@Setter
	private String line1;
	
	@Getter
	@Setter
	private String line2;
	
	@Getter
	@Setter
	private String  city;
	
	@Getter
	@Setter
	private String  state;
	
	@Getter
	@Setter
	private String  country;
	
	@Getter
	@Setter
	private Integer  zipCode;
	
	
	public AddressEntity() {
		super();
	}
	

	public AddressEntity(Address address) {
		this.line1 = address.getLine1();
		this.line2 = address.getLine2();
		this.city = address.getCity();
		this.state = address.getState();
		this.country = address.getCountry();
		this.zipCode = address.getZipCode();
	}
	
	
	public Address getAddress() {
		Address address = new Address();
		address.setCity(city);
		address.setCountry(country);
		address.setLine1(line1);
		address.setLine2(line2);
		address.setState(state);
		address.setZipCode(zipCode);
		return address;
	}
	
}
