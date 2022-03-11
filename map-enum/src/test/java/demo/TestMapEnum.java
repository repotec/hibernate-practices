package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;

import com.demo.Employee;

public class TestMapEnum {
	
	@PersistenceContext
	EntityManager entityManager;
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hr");
	
	@Test
    public void testSelect() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
		List<Employee> result = query.getResultList();
		result.stream().forEach(System.out::println);
		
    }
}
