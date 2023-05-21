package com.demo.joincolumn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class TestOneToManyUnidirectionalWithJoinColumn {
	private static final Logger logger = LogManager.getLogger(TestOneToManyUnidirectionalWithJoinColumn.class); 
	 
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@BeforeAll
    public void init() {
		emf = Persistence.createEntityManagerFactory("hr");
		em = emf.createEntityManager();
		logger.info("start");
    }
	
	@AfterAll
    public void destroy() {
		if(emf != null && emf.isOpen())
			emf.close();
    }
	
	@Test
	@Order(1)
    public void test() {
		em.getTransaction().begin();
		
		Department dept = Department.builder().departmentName("Sales").build();

		em.persist(dept);
		em.flush();
		em.getTransaction().commit();
    }
	
	@Test
	@Order(2)
    public void test_insertNewAuthor() {
		em.getTransaction().begin();
		Department dept = em.find(Department.class, 1L);
		
		Employee emp = Employee.builder().employeeName("Joo").build();
		dept.getEmployees().add(emp);
		
		em.persist(dept);
		em.flush();
		em.getTransaction().commit();
    }
}
