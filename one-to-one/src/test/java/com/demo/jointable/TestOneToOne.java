package com.demo.jointable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
public class TestOneToOne {
	
	private static final Logger logger = LogManager.getLogger(TestOneToOne.class);  
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
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
    public void test() {
		Employee employee = Employee.builder().id(1L)
											  .name("Ahmed")
											  .workStation(WorkStation.builder().id(1L)
													  							.floor(1)
																		  		.build())
											  .build();
		
		em.persist(employee);
		em.flush();
		
		Employee posted = em.find(Employee.class, 1L);
		Assertions.assertThat(employee).usingRecursiveComparison().isEqualTo(posted);
    }
}
