package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.Employee;

@TestInstance(Lifecycle.PER_CLASS)
public class TestNativeQuery {
	
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
		emf.close();
    }
	
	@Test
    public void testSelect() {
		Query query = em.createNativeQuery("select first_name, last_name, department_id "
										 + " from Employees "
										 + " where employee_id = ? "
										 + " and department_id = ?");
		query.setParameter(1, 100);
		query.setParameter(2, 90);
		List<Object[]> result = query.getResultList();
		result.stream().map(e -> "Employee " + e[0] + " " + e[1] + " " + e[2]).forEach(System.out::println);
		

    }
}
