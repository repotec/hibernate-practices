package demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.loader.MultipleBagFetchException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.Artist;

@TestInstance(Lifecycle.PER_CLASS)
public class OneToManyBagFetchExceptionTester {
	
	@PersistenceContext
	EntityManager entityManager;
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@BeforeAll
    public void init() {
		Exception e = Assertions.assertThrows(PersistenceException.class, () -> {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hr");
			if(emf != null) {
				em = emf.createEntityManager();
				em.getTransaction().begin();
			}
		});
		
		assertTrue(e.getCause() instanceof MultipleBagFetchException);
    }
	
	@AfterAll
    public void destroy() {
		if(emf != null)
			emf.close();
    }
	
	@Test
	@DisplayName("test one-to-many MultipleBagFetchException")
    public void testSelect() {
		if(em != null) {
			Query query = em.createNativeQuery("select * from artist", Artist.class);
			List<Artist> artists = query.getResultList();
			artists.stream().forEach(System.out::println);
		}
    }
}
