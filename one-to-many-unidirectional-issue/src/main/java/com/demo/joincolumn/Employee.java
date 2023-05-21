package com.demo.joincolumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "employee_id")
	private long employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
}
