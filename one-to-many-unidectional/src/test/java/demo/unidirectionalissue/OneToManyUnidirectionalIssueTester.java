package demo.unidirectionalissue;

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

import com.demo.unidirectionalJunctionTable.Author;
import com.demo.unidirectionalJunctionTable.Book;
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
		author.setAuthorName("test");
		em.persist(author);
    }
	
	@AfterAll
    public void destroy() {
		if(emf != null && emf.isOpen())
			emf.close();
    }

	/**
	 * this will make Hibernate to create a new table called authors_books, because we don't
	 * use @JoinColumn annotation in child entity
	 */
	@Test
    public void performTest() {
		TypedQuery<Author> query = em.createQuery("SELECT a FROM Author a WHERE a.authorId = :authorId", Author.class);
		query.setParameter("authorId", 1L);
		
		Author author = query.getSingleResult();
		
		Book book = new Book();
		book.setTitle("Hibernate");
		em.persist(book);
					
		author.addBook(book);

		em.getTransaction().commit();
    }
}
