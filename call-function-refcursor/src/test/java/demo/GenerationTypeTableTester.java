package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.JobHistory;

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
		List<Object[]> jobHistoryResultSetMapping = em.createNamedQuery("getJobHistory").setParameter(1, 101L).getResultList();
		jobHistoryResultSetMapping.stream().forEach(o -> System.out.println("JobHistory(employeeId=" + o[0] + ", startDate=" + o[1] + ", endDate=" + o[2] + ", jobId=" + o[3] + ", departmentId=" + o[4] + ")"));
		
		List<JobHistory> jobHistory = em.createNamedQuery("getJobHistoryResultSetMapping").setParameter(1, 101L).getResultList();
		jobHistory.stream().forEach(System.out::println);
		
		List<JobHistory> getJobHistoryFunction = em.createNamedStoredProcedureQuery("getJobHistoryFunction").setParameter(2, "100").getResultList();
		getJobHistoryFunction.stream().forEach(System.out::println);
    }
}
