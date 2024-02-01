package com.demo.single.nested;

import com.demo.embedded.single.basic_embedded.Address;
import com.demo.embedded.single.basic_embedded.Employee;
import com.demo.embedded.single.nested_embedded.Company;
import com.demo.embedded.single.nested_embedded.ContactPerson;
import com.demo.embedded.single.nested_embedded.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import javax.persistence.*;

@TestInstance(Lifecycle.PER_CLASS)
public class NestedEmbeddedTest {

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
	@Order(1)
	void addNewCompany_test() {
		Name name = new Name("Ahmed", "mohammed", "mamdouh");
		ContactPerson contactPerson = new ContactPerson(name, "01922777423");
		Company newCompany = Company.builder().companyId(1).companyName("TTT").contactPerson(contactPerson).build();

		em.persist(newCompany);
		em.flush();
	}

	@Test
	void testRetrieve() {
		TypedQuery<Company> query = em.createQuery("select e from Companies e where e.companyId = :v", Company.class);
		query.setParameter("v", 1);
		Company company = query.getSingleResult();
		System.out.println(company.toString());
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
