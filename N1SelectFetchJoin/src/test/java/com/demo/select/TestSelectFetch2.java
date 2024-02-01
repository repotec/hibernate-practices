package com.demo.select;

import com.demo.issue.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import javax.persistence.*;
import java.util.List;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSelectFetch2 {
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
	public void testRetrieveCustomer_whenSelectCustomer_dataShouldRetrieved() {
		Customer customer = em.find(Customer.class, 1L);
		List<com.demo.issue.Order> orders = customer.getOrders();
		orders.forEach(e -> System.out.println("ProductName:" + e.getProductName()));
	}
}
