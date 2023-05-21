package com.demo.foreignkey;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
		User user = User.builder().id(2L)
						.username("Ahmed")
						.address(Address.builder().id(2L)
												  .street("Ali hussain")
												  .city("Cairo")
												  .build())
						.build();
		
		em.persist(user);
		em.flush();
		
		User postedUser = em.find(User.class, 2L);
		Assertions.assertThat(user).usingRecursiveComparison().isEqualTo(postedUser);
    }
	
	@Test
	@Order(2)
    public void testRetrieve() {
		TypedQuery<User> query = em.createQuery("select u from User u", User.class);
		List<User> result = query.getResultList();
		
		result.stream().forEach(System.out::println);
		Assertions.assertThat(result.size()).isGreaterThan(0);
    }
}
