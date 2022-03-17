package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import com.demo.Author;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class BasicEntityListener {
	
	@PersistenceContext
	EntityManager entityManager;
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@BeforeAll
    public void init() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hr");
		if(emf != null) 
			em = emf.createEntityManager();
    }
	
	@AfterAll
    public void destroy() {
		if(emf != null)
			emf.close();
    }
	
	@Test
	@Order(1)
	@DisplayName("test basic entity listener insert")
    public void testBasicEntityListenerInsert() {
		Author author = new Author();
		author.setId(1000L);
		author.setName("Test");
		
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
    }
	
	@Test
	@Order(2)
	@DisplayName("test basic entity listener update")
    public void testBasicEntityListenerUpdate() {
		Author author = em.find(Author.class, 1000L);
		author.setName("Test update");
		
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
    }
	
	@Test
	@Order(3)
	@DisplayName("test basic entity listener delete")
    public void testBasicEntityListenerDelete() {
		Author author = em.find(Author.class, 1000L);
		em.getTransaction().begin();
		em.remove(author);
		em.getTransaction().commit();
    }
}
