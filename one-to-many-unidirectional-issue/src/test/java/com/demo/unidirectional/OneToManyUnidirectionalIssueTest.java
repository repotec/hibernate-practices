package com.demo.unidirectional;

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
public class OneToManyUnidirectionalIssueTest {
	private static final Logger logger = LogManager.getLogger(OneToManyUnidirectionalIssueTest.class); 
	 
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@BeforeAll
    public void init() {
		emf = Persistence.createEntityManagerFactory("hr");
		em = emf.createEntityManager();
		
    }
	
	@AfterAll
    public void destroy() {
		if(emf != null && emf.isOpen())
			emf.close();
    }
	
	@Test
	@Order(1)
    public void test1() {
		em.getTransaction().begin();
		
		Post post = Post.builder().postName("test").build();

		em.persist(post);
		em.flush();
		em.getTransaction().commit();
    }
	
	@Test
	@Order(2)
    public void test2() {
		em.getTransaction().begin();
		Post post = em.find(Post.class, 1L);
		logger.info("*******" + post);
		
		Comment comment = Comment.builder().text("up!").postId(1L).build();

		post.getComments().add(comment);
		
		em.persist(post);
		em.flush();
		em.getTransaction().commit();
    }
}
