package com.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@EntityListeners(AuditTrailListener.class)
@Table(name = "authors")
@Getter
@Setter
public class Author {
	@Id
	@Column(name = "id")
    private Long id;

	@Column(name = "Name")
    private String name;
}
