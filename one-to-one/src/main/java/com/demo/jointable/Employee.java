package com.demo.jointable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	@Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_workstation", 
		      joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "id") },
		      inverseJoinColumns = { @JoinColumn(name = "workstation_id", referencedColumnName = "id") })
    private WorkStation workStation;
}
