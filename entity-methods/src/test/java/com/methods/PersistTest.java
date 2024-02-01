package com.methods;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@TestMethodOrder(MethodOrderer.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersistTest {
    EntityManagerFactory emf = null;
    EntityManager em = null;

    @BeforeAll
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hr");
        if(emf != null)
            em = emf.createEntityManager();
    }


    @AfterAll
    public void destroy() {
        if(emf != null)
            emf.close();
    }

    @Test
    @Order(1)
    void persistTest(){
        em.getTransaction().begin();
        Department department = new Department(1L, "HR");

        em.persist(department);
        em.getTransaction().commit();
    }
}
