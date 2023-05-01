package com.demo.select;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

import com.demo.join.Department;
import com.demo.join.Employee;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSelectFetch {

	private static final Logger logger = LogManager.getLogger(TestSelectFetch.class);

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
		TypedQuery<Department> query = em.createQuery("select d from Department d where d.departmentId = :v", Department.class);
		query.setParameter("v", 1);
	
		Department department = query.getSingleResult();
	
		Set<Employee> employees = department.getEmployees();
		employees.forEach(e -> System.out.println(e.getEmployeeId()));
	}
}
