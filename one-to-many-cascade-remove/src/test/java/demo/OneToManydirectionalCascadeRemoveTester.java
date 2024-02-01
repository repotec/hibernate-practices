package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.Author;
import com.demo.Book;

/**
 * The problem with this mapping is that Hibernate needs to execute proper lifecycle transitions for all entities. 
 * So, Hibernate needs to select all associated Item entities and remove them one by one.
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
@Slf4j
public class OneToManydirectionalCascadeRemoveTester {

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

	/**
	 * The Hibernate will select all associated Item entities and remove them one by one.
	 * Which is pad, we should think twice before using CascadeType.Remove
	 */
	@Test
    public void test() {
		log.info("start deleting");
		Author author = em.find(Author.class, 1L);
		em.remove(author);
		em.getTransaction().commit();
    }
}
