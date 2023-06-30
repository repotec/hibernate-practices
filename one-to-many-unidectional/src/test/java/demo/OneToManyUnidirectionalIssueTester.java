package demo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
		Author author = new Author();
		author.setAutherName("test");
		em.persist(author);
    }
	
	@AfterAll
    public void destroy() {
		if(emf != null && emf.isOpen())
			emf.close();
    }
	
	@Test
    public void performTest() {
		TypedQuery<Author> auery = em.createQuery("SELECT a FROM Author a WHERE a.autherId = :autherId", Author.class);
		auery.setParameter("autherId", 1L);
		
		Author author = auery.getSingleResult();
		
		Book book = new Book();
		book.setTitle("Hibernate");
		em.persist(book);
					
		author.addBook(book);

		em.getTransaction().commit();
    }
}
