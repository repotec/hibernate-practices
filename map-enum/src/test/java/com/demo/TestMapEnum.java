package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMapEnum {
	
	 private static final Logger logger = LogManager.getLogger(TestMapEnum.class);  
	
	@PersistenceContext
	EntityManager entityManager;
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@BeforeAll
    public void init() {
		emf = Persistence.createEntityManagerFactory("hr");
		em = emf.createEntityManager();
		em.getTransaction().begin();
    }
	
	@AfterAll
    public void destroy() {
		emf.close();
    }
	
	@Test
	@Order(1)
    public void testRetrieveEmployees_whenSelectEmployees_dataShouldRetrieved() {
		TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
		List<Employee> result = query.getResultList();
		
		result.stream().forEach(System.out::println);
		Assertions.assertThat(result.size()).isGreaterThan(0);
		logger.info("**********************************************************************");
    }
	
	@Test
	@Order(2)
    public void testInsertEmployee_whenPassJobIdEnum_dataShouldPersisted() {
		Employee employee = Employee.builder().employeeId(1000)
											  .firstName("Ahmed")
											  .lastName("Mohammed")
											  .jobId(JobId.AC_ACCOUNT)
											  .build();
		em.persist(employee);								 
		em.flush();
		logger.info("**********************************************************************");
    }
	
	@Test
	@Order(3)
	void testRetrieveNewEmployee_whenSelectNewAC_ACCOUNTEmployee_dataShouldRetrieved() {
		//given
		Employee employee = Employee.builder().employeeId(1000)
											  .firstName("Ahmed")
											  .lastName("Mohammed")
											  .jobId(JobId.AC_ACCOUNT)
											  .build();
		
		//when
		TypedQuery<Employee> query = em.createQuery("select e from Employee e where employee_id = ?1", Employee.class);
		query.setParameter(1, 1000);
		List<Employee> result = query.getResultList();
		System.out.println(result);
		
		//then
		Assertions.assertThat(result.get(0)).usingRecursiveComparison().isEqualTo(employee);
		logger.info("**********************************************************************");
	}
	
	
	@Test
	@Order(4)
	void testRetrieveEmployees_whenQueryAC_ACCOUNT_Enum_dataShouldRetrieved() {
		//when
		TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.jobId = ?1", Employee.class);
		query.setParameter(1, JobId.AC_ACCOUNT);
		List<Employee> result = query.getResultList();
		System.out.println(result);
		
		//then
		Assertions.assertThat(result.size()).isEqualTo(2);
		logger.info("**********************************************************************");
	}
	
}
