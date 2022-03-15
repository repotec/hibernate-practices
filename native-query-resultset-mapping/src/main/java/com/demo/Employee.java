package com.demo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@SqlResultSetMapping(
        name = "EmployeeMapping",
        entities = @EntityResult(entityClass = Employee.class,
        						 fields = {
        								 @FieldResult(name = "employeeId", column = "EMPLOYEE_ID"),
        								 @FieldResult(name = "firstName", column = "FIRST_NAME"),
        								 @FieldResult(name = "lastName", column = "LAST_NAME"),
        								 @FieldResult(name = "email", column = "EMAIL"),
        								 @FieldResult(name = "phoneNumber", column = "PHONE_NUMBER"),
        								 @FieldResult(name = "hireDate", column = "HIRE_DATE"),
        								 @FieldResult(name = "jobId", column = "JOB_ID"),
        								 @FieldResult(name = "salary", column = "SALARY"),
        								 @FieldResult(name = "commissionPct", column = "COMMISSION_PCT"),
        								 @FieldResult(name = "managerId", column = "MANAGER_ID"),
        								 @FieldResult(name = "departmentId", column = "DEPARTMENT_ID"),
        						 }) )
public class Employee {
	public Employee() {
	}
	
	@Id
	@Column(name = "EMPLOYEE_ID")
	private BigDecimal employeeId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "HIRE_DATE")
	private Date hireDate;
	
	@Column(name = "JOB_ID")
	private String jobId;
	
	@Column(name = "SALARY")
	private BigDecimal salary;
	
	@Column(name = "COMMISSION_PCT")
	private BigDecimal commissionPct;
	
	@Column(name = "MANAGER_ID")
	private BigDecimal managerId;
	
	@Column(name = "DEPARTMENT_ID")
	private BigDecimal departmentId;

	public BigDecimal getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(BigDecimal employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public BigDecimal getManagerId() {
		return managerId;
	}

	public void setManagerId(BigDecimal managerId) {
		this.managerId = managerId;
	}

	public BigDecimal getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId.toString() + ", salary="
				+ salary + ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId="
				+ departmentId + "]";
	}
}
