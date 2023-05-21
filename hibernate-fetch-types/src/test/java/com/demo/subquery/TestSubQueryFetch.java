package com.demo.subquery;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
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
import org.junit.jupiter.api.TestMethodOrder;

import com.demo.join.Author;
import com.demo.join.Author;
import com.demo.subquery.Customer;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSubQueryFetch {

	private static final Logger logger = LogManager.getLogger(TestSubQueryFetch.class);

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
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> o = cq.from(Customer.class);
		List<Customer> customers = em.createQuery(cq.select(o)).getResultList();
		Set<com.demo.subquery.Order> orders = customers.get(0).getOrders();
		orders.stream().forEach((order) -> order.getOrderId());
	}
}
