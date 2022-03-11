package demo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.Employee;

@TestInstance(Lifecycle.PER_CLASS)
public class GenerationTypeTableTester {
	
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
    public void performTest() {
		Employee emp = new Employee();
		emp.setFirstName("Sara");
		emp.setLastName("Lee");
		emp.setEmail("Sara.lee");
		emp.setPhoneNumber("603.556.6060");
		emp.setJobId("IT_PROG");
		emp.setHireDate(new Date(new java.util.Date().getTime()));
		emp.setSalary(BigDecimal.valueOf(4000L));
		emp.setCommissionPct(BigDecimal.valueOf(0.5F));
		emp.setManagerId(100L);
		emp.setDepartmentId(90L);
		
		em.persist(emp);
		
		em.getTransaction().commit();
    }
}
