package com.demo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private long employeeId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;	

	@Column(name = "job_id")
	@Enumerated(EnumType.STRING)
	private JobId jobId;
}
