package com.demo.embedded.single.basic_embedded;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;	

	//@Embedded
	@AttributeOverrides({@AttributeOverride(name = "zipCode", column = @Column(name = "zip_code"))})
	private Address address;

	//getters and setters
}
