package demo.unidirectional;

import com.demo.unidirectional.Department;
import com.demo.unidirectional.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import javax.persistence.*;

@TestInstance(Lifecycle.PER_CLASS)
public class OneToManyUnidirectionalIssueTest {
	
	@PersistenceContext
	EntityManager entityManager;
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@BeforeAll
    public void init() {
		emf = Persistence.createEntityManagerFactory("hr");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	
		Department dept = new Department();
		dept.setName("SALES");
		em.persist(dept);
    }
	
	@AfterAll
    public void destroy() {
		if(emf != null && emf.isOpen())
			emf.close();
    }

	@Test
    public void performTest() {
		TypedQuery<Department> query = em.createQuery("SELECT a FROM Department a WHERE a.id = :id", Department.class);
		query.setParameter("id", 1L);

		Department author = query.getSingleResult();
		
		Employee book = new Employee();
		book.setName("Ahmed");
		em.persist(book);
					
		author.addEmployee(book);

		em.getTransaction().commit();
    }
}
