package com.demo.collection.basiccollection;

import com.demo.embedded.collection.basiccollection_embedded.Developer;
import com.demo.embedded.collection.basiccollection_embedded.Skills;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Arrays;

@TestInstance(Lifecycle.PER_CLASS)
public class BasicCollectionTest {

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
	void addNewDeveloperWith_test() {
		Developer developer = new Developer();
		developer.setId(1L);
		developer.setName("Alice");
		Skills skills = new Skills();
		skills.setLanguages(Arrays.asList("Java", "Python"));
		skills.setFrameworks(Arrays.asList("Spring Boot", "Django"));
		developer.setSkills(skills);

		em.persist(developer);
		em.flush();
	}

	@Test
	void testRetrieve() {
		TypedQuery<Developer> query = em.createQuery("select d from Developer d where d.id = :developerId", Developer.class);
		query.setParameter("developerId", 1L);
		Developer developer = query.getSingleResult();

		developer.getSkills().getLanguages().forEach(System.out::println);
		developer.getSkills().getFrameworks().forEach(System.out::println);
	}
}
