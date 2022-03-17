package com.demo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
	@Id
	@Column(name = "id")
    private Long id;

	@Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Book> books;
    
    @PrePersist
    public void logNewAuthorAttempt() {
        System.out.println("Attempting to add new Author with name: " + name);
    }
        
    @PostPersist
    public void logNewAuthorAdded() {
    	System.out.println("Added Author '" + name + "' with ID: " + id);
    }
        
    @PreRemove
    public void logAuthorRemovalAttempt() {
    	System.out.println("Attempting to delete boAuthorok: " + name);
    }
        
    @PostRemove
    public void logAuthorRemoval() {
    	System.out.println("Deleted Author: " + name);
    }

    @PreUpdate
    public void logAuthorUpdateAttempt() {
    	System.out.println("Attempting to update Author: " + name);
    }

    @PostUpdate
    public void logAuthorUpdate() {
    	System.out.println("Updated Author: " + name);
    }

    @PostLoad
    public void logAuthorLoad() {
    	System.out.println("logAuthorLoad");
    }
}
