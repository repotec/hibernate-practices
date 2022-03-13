package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.User;

@TestInstance(Lifecycle.PER_CLASS)
public class ManyToManyMultipleBagFetchExceptionTester {
	
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
		em.getTransaction().commit();
		emf.close();
    }
	
	@Test
    public void testSelect() {
		Query query = em.createNativeQuery("select * from users", User.class);
		List<User> users = query.getResultList();
		
		users.stream().forEach(u -> {
			System.out.println(u.getUserName());
			u.getGroups().stream().forEach(System.out::println);
		});
    }
}
