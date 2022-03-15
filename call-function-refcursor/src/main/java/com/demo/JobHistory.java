package com.demo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.QueryHint;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@NamedStoredProcedureQuery(
		  name = "getJobHistoryFunction",
		  procedureName = "GET_JOB_HISTORY",
		  resultClasses = JobHistory.class,
		  parameters = {
						  @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class),
						  @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class)
				  	   }
		)

@NamedNativeQuery(name = "getJobHistory", 
				query = "{? = call GET_JOB_HISTORY(?)}", 
				hints = { @QueryHint(name = "org.hibernate.callable", value = "true") })

@NamedNativeQuery(name = "getJobHistoryResultSetMapping", 
				  query = "{? = call GET_JOB_HISTORY(?)}", 
				  resultSetMapping = "JobHistoryMap",
				  hints = { @QueryHint(name = "org.hibernate.callable", value = "true") })
@SqlResultSetMapping(
	    name = "JobHistoryMap",
	    entities = {
	        @EntityResult(
	            entityClass = JobHistory.class,
	            fields = {
	                @FieldResult(name = "employeeId", column = "EMPLOYEE_ID"),
	                @FieldResult(name = "startDate", column = "START_DATE"),
	                @FieldResult(name = "endDate", column = "END_DATE"),
	                @FieldResult(name = "jobId", column = "JOB_ID"),
	                @FieldResult(name = "departmentId", column = "DEPARTMENT_ID"),
	            }
	        )
	    }
	)
@Immutable
@Table(name = "JOB_HISTORY")
public class JobHistory {
	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;
	
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "JOB_ID")
	private String jobId;

	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
}
