package com.persistence;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionScopedTest {

    EntityManagerFactory emf;

    @PersistenceContext
    EntityManager em;

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
    @Transactional
    void insertDepartmentTest(){
        Department department = new Department(1L, "HR");
        em.persist(department);
    }

    @Test
    @Order(2)
    void updateDepartmentWithoutTransactionTest(){
        Department department = em.find(Department.class, 1L);
        department.setDepartmentName("OPERATIONS");
        em.persist(department);
    }
}
