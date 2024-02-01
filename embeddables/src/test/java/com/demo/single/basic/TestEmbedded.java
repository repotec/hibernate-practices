package com.demo.single.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.demo.embedded.single.basic_embedded.Address;
import com.demo.embedded.single.basic_embedded.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TestEmbedded {
	
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
	void testRetrieve() {
		TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.employeeId = :v", Employee.class);
		query.setParameter("v", 1);
		Employee employee = query.getSingleResult();
		System.out.println(employee.toString());
	}
	
	@Test
	void testInsert() {
		Address address = Address.builder().street("Zaker Hussain").city("Alex").country("Egypt").zipCode("11321").build();
		Employee newEmployee = Employee.builder().employeeId(2).firstName("ahmed").lastName("mohammed").address(address).build();
		
		em.persist(newEmployee);
		em.flush();
		
		TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.employeeId = :employeeId", Employee.class);
		query.setParameter("employeeId", 2);
		Employee employee = query.getSingleResult();
		System.out.println(employee.toString());
	}
	
	
	@Test
	void testUpdate() {
		TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.employeeId = :employeeId", Employee.class);
		query.setParameter("employeeId", 2);
		Employee employee = query.getSingleResult();
		Address address = employee.getAddress();
		
		//when
		address.setCity("Aswan");
		Employee updatedEmployee = em.merge(employee);
		em.flush();
		
		//then
		Assertions.assertThat("Aswan").isEqualTo(updatedEmployee.getAddress().getCity());
	}
}
