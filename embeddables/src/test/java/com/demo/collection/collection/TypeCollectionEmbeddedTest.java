package com.demo.collection.collection;

import com.demo.embedded.collection.collections_embedded.Clerk;
import com.demo.embedded.collection.collections_embedded.Job;
import org.assertj.core.util.Sets;
import org.hibernate.event.spi.PostInsertEventListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TypeCollectionEmbeddedTest {

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
	@Order(1)
	void addNewClerk_test() {
		Job accountant = new Job(1L, "ACCOUNTANT");
		Job reporter = new Job(1L, "REPORTER");

		Clerk clerk = Clerk.builder().clerkIdPk(1L).name("Ahmed").build();
		clerk.setJobs(Sets.set(accountant, reporter));
		em.persist(clerk);
		em.flush();
	}

	@Test
	@Order(2)
	void retrieveClerkTest() {
		TypedQuery<Clerk> query = em.createQuery("select c from Clerk c where c.clerkIdPk = :clerkIdPk", Clerk.class);
		query.setParameter("clerkIdPk", 1L);
		Clerk clerk = query.getSingleResult();

		clerk.getJobs().forEach(Job::getTitle);
	}
}
