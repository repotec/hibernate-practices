package com.demo.sharedprimarykey;

import java.util.Date;
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
		Post post = Post.builder().id(2L)
						.title("Photo in there")
						.postDetails(PostDetails.builder().id(2L)
												  .createdBy("Joo")
												  .createdOn(new Date())
												  .build())
						.build();
		
		em.persist(post);
		em.flush();
		
		Post posted = em.find(Post.class, 2L);
		Assertions.assertThat(post).usingRecursiveComparison().isEqualTo(posted);
    }
	
	@Test
	@Order(2)
    public void testRetrieve() {
		TypedQuery<Post> query = em.createQuery("select u from User u", Post.class);
		List<Post> result = query.getResultList();
		
		result.stream().forEach(System.out::println);
		Assertions.assertThat(result.size()).isGreaterThan(0);
    }
}
