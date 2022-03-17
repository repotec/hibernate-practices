package com.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books", uniqueConstraints = @UniqueConstraint(name ="name_unq", columnNames = {"name"}))
@Getter
@Setter
public class Book {
	@Id
    private Long id;

	@Column(name = "Name")
    private String name;
	
	@Column(name = "isbn")
	private String isbn;
}
