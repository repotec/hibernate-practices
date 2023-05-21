package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class EmbeddedElementCollection {
	
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
		if(emf != null && emf.isOpen())
			emf.close();
    }
	
	@Test
    public void testEmbeddedElementCollection() {
		TypedQuery<Employee> q = em.createQuery("SELECT e FROM Employee e", Employee.class);
		List<Employee> emp = q.getResultList();
		emp.forEach((e) -> {
			 System.out.println("*** " + e.toString());
			
			e.getAddresses().forEach(a -> System.out.println("****** " + a.toString()));
		} );
		
    }
}
