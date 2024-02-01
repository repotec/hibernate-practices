package com.ahd.chat;

import com.demo.cascadingnonowner.Application;
import com.demo.cascadingnonowner.ApplicationTranslation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OneToManyBidirectional_cascasing_in_non_owningSideTest {
	private static final Logger logger = LogManager.getLogger(OneToManyBidirectional_cascasing_in_non_owningSideTest.class);
	 
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

	/**
	 *
	 * When we create a new Application entity and a new ApplicationTranslation entity,
	 * we have to set both sides of the relationship.
	 */
	@Test
	@Order(1)
    public void performTest() {
		logger.info("start test case");

		//application
		Application application = new Application();
		application.setApplicationIdPk(1L);
		application.setApplicationName("Administration Application");

		//application translations
		ApplicationTranslation applicationTranslation1 = new ApplicationTranslation();
		applicationTranslation1.setApplicationTranslationId(1L);
		applicationTranslation1.setApplicationDisplayName("Admin");

		ApplicationTranslation applicationTranslation2 = new ApplicationTranslation();
		applicationTranslation2.setApplicationTranslationId(2L);
		applicationTranslation2.setApplicationDisplayName("Administration");

		application.setApplicationTranslations(Arrays.asList(applicationTranslation1, applicationTranslation2));

		em.persist(application);
    }

	@Test
	@Order(2)
	@Disabled
	public void performTest2() {
		//application
		Application application = new Application();
		application.setApplicationIdPk(1L);
		application.setApplicationName("Administration Application");

		//application translations
		ApplicationTranslation applicationTranslation1 = new ApplicationTranslation();
		applicationTranslation1.setApplicationTranslationId(1L);
		applicationTranslation1.setApplicationDisplayName("Admin");

		ApplicationTranslation applicationTranslation2 = new ApplicationTranslation();
		applicationTranslation2.setApplicationTranslationId(2L);
		applicationTranslation2.setApplicationDisplayName("Administration");

		application.setApplicationTranslations(Arrays.asList(applicationTranslation1, applicationTranslation2));

		em.persist(application);
	}
}
