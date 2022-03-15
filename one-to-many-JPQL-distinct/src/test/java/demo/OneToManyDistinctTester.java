package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.jpa.QueryHints;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.Author;

@TestInstance(Lifecycle.PER_CLASS)
public class OneToManyDistinctTester {
	
	@PersistenceContext
	EntityManager entityManager;
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@BeforeAll
    public void init() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hr");
		if(emf != null) {
			em = emf.createEntityManager();
			em.getTransaction().begin();
		}
    }
	
	@AfterAll
    public void destroy() {
		if(emf != null)
			emf.close();
    }
	
	@Test
	@DisplayName("test one-to-many")
    public void testSelect() {
		TypedQuery<Author> query = em.createQuery("select DISTINCT a from Author a JOIN FETCH a.books", Author.class);
		//query.setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
		List<Author> authors = query.getResultList();
		authors.stream().forEach(a -> {
			System.out.println("author:" + a.getName() + " has [" + a.getBooks().size() + "] books:");
			
			a.getBooks().stream().forEach(b -> {
				System.out.println("\t-" + b.getName());
			});
		});
    }
}
