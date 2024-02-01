package com.demo.bidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OneToManyBidirectionaTest {
	private static final Logger logger = LogManager.getLogger(OneToManyBidirectionaTest.class); 
	 
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
		if(emf != null && emf.isOpen())
			emf.close();
    }
	
	@Test
	@org.junit.jupiter.api.Order(1)
    public void performTest() {
		logger.info("start test case");
		List<Item> items = new ArrayList<>();
		
		items.add(Item.builder().itemId(1L)
								.itemName("Cola")
								.build());
		
		Order order = Order.builder().orderId(1L)
													 .totalPrice(100L)
												     .items(items)
												     .build();
		
		em.persist(order);
		em.flush();
		em.getTransaction().commit();
		logger.info("end test case");
    }
	
	@Test
	@org.junit.jupiter.api.Order(2)
    public void performTest2() {
		logger.info("start test case");
		
		Order order = em.find(Order.class, 1L);
		
		order.getItems().stream().forEach((item) -> System.out.println(item.getItemId()));
		logger.info("end test case");
    }
}
