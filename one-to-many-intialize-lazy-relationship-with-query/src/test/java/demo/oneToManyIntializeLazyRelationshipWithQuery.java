package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import com.demo.Author;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class oneToManyIntializeLazyRelationshipWithQuery {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@BeforeAll
    public void init() {
		emf = Persistence.createEntityManagerFactory("hr");
    }
	
	@AfterAll
    public void after() {
		emf.close();
    }

	
	@Test
	@Order(1)
	@DisplayName("test one-to-many_selectWithoutFetchJoin")
    public void testSelectWithoutFetchJoin() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Author> query = em.createQuery("select a from Author a where a.id = 1", Author.class);
		Author authors = query.getSingleResult();
		
		Exception e = Assertions.assertThrows(LazyInitializationException.class, ()->{
			em.getTransaction().commit();
			em.close();
		});

		Assertions.assertTrue(e instanceof LazyInitializationException);
	}
	
	@Test
	@Order(2)
	@DisplayName("test one-to-many_selectWithFetchJoin")
    public void testSelectWithFetchJoin() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Author> query = em.createQuery("select a from Author a JOIN FETCH a.books where a.id = 1", Author.class);
		Author authors = query.getSingleResult();
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println("author:" + authors.getName() + " has [" + authors.getBooks().size() + "] books");
    }
}
