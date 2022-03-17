package com.demo;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;


public class AuditTrailListener {

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Object entity) {
        System.out.println("About to add/update/delete complete");
    }
    
    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(Object entity) {
        System.out.println("add/update/delete complete");
    }
    
    @PostLoad
    private void afterLoad(Object entity) {
    	System.out.println("loaded from database");
    }
}
