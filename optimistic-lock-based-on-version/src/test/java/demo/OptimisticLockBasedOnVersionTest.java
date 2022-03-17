package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import com.demo.Book;

@TestInstance(Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
@TestMethodOrder(OrderAnnotation.class)
public class OptimisticLockBasedOnVersionTest {
	EntityManagerFactory emf = null;
	
	@BeforeAll
	public void init() {
		emf = Persistence.createEntityManagerFactory("hr");
	}
	
	@Test
	@DisplayName("test basic entity listener insert")
	@Order(1)
	public void testBasicEntityListenerInsert() {
		Exception e = Assertions.assertThrows(RollbackException.class, ()->{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Book book = em.find(Book.class, 1L);
			System.out.println("start update statement 1 ...... " + book.toString());
			book.setTitle("Test");

			try {
				System.out.println("start update statement 1 wait for 2 seconds ...... " + book.toString());
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			em.getTransaction().commit();
			em.close();
		});
		
		Assertions.assertTrue(e.getCause() instanceof OptimisticLockException);
	}
	
	@Test
	@DisplayName("test basic entity listener insert")
	@Order(2)
	public void testBasicEntityListenerInser2t() {
	
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Book book = em.find(Book.class, 1L);
		book.setTitle("Test");
		System.out.println("start update statement 2 ...... " + book.toString());
		
		em.getTransaction().commit();
		
		System.out.println("end update statement 2 ...... " + book.toString());
		em.close();
	}
}
