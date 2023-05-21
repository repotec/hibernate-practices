package com.demo.select;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.subquery.Customer;

import org.junit.jupiter.api.TestMethodOrder;

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

	/**
	 * in case of using explicit HQL query, Hibernate will not respect the annotated Fetch mode. 
	 * We would need to specify the join in the HQL query or the fetch mode in the criteria.
	 */
	@Test
	@Order(1)
	public void testRetrieveEmployees_whenSelectEmployees_dataShouldRetrieved() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Department> cq = cb.createQuery(Department.class);
		Root<Department> o = cq.from(Department.class);
		List<Department> departments = em.createQuery(cq.select(o)).getResultList();
		Set<Employee> employees = departments.get(0).getEmployees();
		employees.forEach(e -> System.out.println(e.getEmployeeId()));
	}
}
