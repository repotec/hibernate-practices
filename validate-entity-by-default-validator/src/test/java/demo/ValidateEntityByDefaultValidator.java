package demo;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.Employee;

@TestInstance(Lifecycle.PER_CLASS)
public class ValidateEntityByDefaultValidator {
	
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
	@DisplayName(value = "whenLeaveLastnameEmptyOrLessThan5OrMoreThan20_thenShouldGiveConstraintViolations")
    public void whenLeaveLastnameEmptyOrLessThan5OrMoreThan20_thenShouldGiveConstraintViolations() {
		Employee emp = new Employee();
		emp.setLastName("amr");
		emp.setEmployeeId(1000);
		emp.setFirstName("test");
		emp.setPhoneNumber("999-999-999");
		
		em.persist(emp);
		Exception e = Assertions.assertThrows(PersistenceException.class, ()->{
			em.getTransaction().commit();
		});
		
		System.out.println(e.getCause());
		Assertions.assertTrue(e.getCause() instanceof ConstraintViolationException);
    }
}
