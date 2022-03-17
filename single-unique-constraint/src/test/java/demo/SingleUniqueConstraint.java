package demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;

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

import com.demo.Book;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class SingleUniqueConstraint {
	
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
	@DisplayName("test Single Unique Constraint (insert)")
    public void testSingleUniqueConstraintInsert() {
		Book book = new Book();
		book.setId(10L);
		book.setName("Java");
		book.setIsbn("65493");
		
		em.getTransaction().begin();
		em.persist(book);
		
		Exception e = Assertions.assertThrows(RollbackException.class, ()->{
			em.getTransaction().commit();
		});
		
		assertTrue(e.getCause() instanceof ConstraintViolationException);
		
    }
	
	@Test
	@Order(2)
	@DisplayName("test single unique constraint (update)")
    public void testSingleUniqueConstraintUpdate() {
		Book book = em.find(Book.class, 2L);
		book.setName("Java");
		book.setIsbn("65493");
		
		em.getTransaction().begin();
		em.persist(book);
		
		Exception e = Assertions.assertThrows(RollbackException.class, ()->{
			em.getTransaction().commit();
		});
		
		assertTrue(e.getCause() instanceof ConstraintViolationException);
    }
}
