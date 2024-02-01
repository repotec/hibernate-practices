package com.demo.unidirectional;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import javax.persistence.*;


@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class OneToOneUnidirectionalTest {
	
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
		Publisher publisher = new Publisher();
		publisher.setPublisherIdPk(1L);
		publisher.setName("O'Reilly Media");

		Book book = new Book();
		book.setBookId(1L);
		book.setTitle("Java Persistence with Hibernate");
		book.setPublisher(publisher);

		em.persist(book);
    }

	@Test
	@Order(2)
	public void retrieve() {
		Book persistedBook = em.find(Book.class, 1L);
		System.out.println(persistedBook.getPublisher().getName());
	}
}