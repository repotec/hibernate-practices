package com.demo.mappedbybidirectional;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.assertj.core.api.Assertions;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class OneToOneMappedByTest {
	
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
		Job job = Job.builder().id(1L).title("ACCOUNTANT").build();
		Clerk clerk = Clerk.builder().id(1L).name("Ahmed").build();
		clerk.setJob(job);

		em.persist(clerk);

		Clerk persistedClerk = em.find(Clerk.class, 1L);
		Assertions.assertThat(persistedClerk).usingRecursiveComparison().isEqualTo(clerk);
    }
}
