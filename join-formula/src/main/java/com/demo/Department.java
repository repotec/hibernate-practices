package com.demo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id
	@Column(name = "department_id")
	private long employeeId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "manager_id")
	private long managerId;	

	@Column(name = "location_id")
	private long locationId;	
	
	@OneToMany(mappedBy = "department")
	private Set<Employee> employees;
}
