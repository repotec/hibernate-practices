package demo;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.Author;
import com.demo.Book;

@TestInstance(Lifecycle.PER_CLASS)
public class OneToManyUnidirectionalIssueTester {
	
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
    public void performTest() {
		Author author = em.find(Author.class, 1L);
		
		Book book = new Book();
		book.setBookId(100L);
		em.persist(book);
					
		author.getBooks().add(book);

		em.getTransaction().commit();
    }
}
