package com.demo.select;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
public class Department {
	
	@Id
	@Column(name = "DEPARTMENT_ID")
	private Integer departmentId;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;
	
	@OneToMany(mappedBy = "department")
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 2)
	private Set<Employee> employees;
}
