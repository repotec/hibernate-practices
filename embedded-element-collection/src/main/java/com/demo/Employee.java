package com.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
	@Id
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;	

    @ElementCollection
    @CollectionTable(name = "addresses", joinColumns = @JoinColumn(name = "employee_id"))
    @AttributeOverrides({@AttributeOverride(name = "zipCode", column = @Column(name = "zip_code"))})
    @Column(name = "address")
    //@OrderBy("city desc")
    @OrderColumn(name = "zip_code")
    private Set<Address> addresses = new HashSet<>();
}
