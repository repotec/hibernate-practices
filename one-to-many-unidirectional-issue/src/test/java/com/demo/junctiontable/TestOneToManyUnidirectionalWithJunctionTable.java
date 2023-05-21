package com.demo.junctiontable;

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
public class TestOneToManyUnidirectionalWithJunctionTable {
	private static final Logger logger = LogManager.getLogger(TestOneToManyUnidirectionalWithJunctionTable.class); 
	 
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
    public void test() {
		em.getTransaction().begin();
		
		Author author = Author.builder().autherName("test")
										.build();

		em.persist(author);
		em.flush();
		em.getTransaction().commit();
    }
	
	@Test
	@Order(2)
    public void test_insertNewAuthor() {
		em.getTransaction().begin();
		Author author = em.find(Author.class, 1L);
		logger.info("*******" + author);
		
		Book book = Book.builder().title("Action").build();
		author.getBooks().add(book);
		
		em.persist(author);
		em.flush();
		em.getTransaction().commit();
    }
}
