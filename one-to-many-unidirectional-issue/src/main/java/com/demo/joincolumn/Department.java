package com.demo.joincolumn;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Department {
	/**
	 * Add @JoinColumn to avoid a junction table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "department_id")
	private long departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@OneToMany
	@JoinColumn(name = "employee_id")
	@Builder.Default
	private Set<Employee> employees = new HashSet<>();
}
