package com.persistence;

import org.junit.jupiter.api.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExtendedScopedTest {

    EntityManagerFactory emf;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager em;

    @BeforeAll
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hr");
        if(emf != null) {
            em = emf.createEntityManager();
            em.setFlushMode(FlushModeType.COMMIT);
        }
    }


    @AfterAll
    public void destroy() {
        if(emf != null)
            emf.close();
    }

    @Test
    @Order(1)
    @Transactional
    void insertDepartmentWithTransactionTest(){
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

