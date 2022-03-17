package com.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books")
@Getter
@Setter
@DynamicUpdate
@ToString
public class Book {
	@Id
	@Column(name = "id")
    private long id;
	
	@Column(name = "title")
    private String title;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "number_of_pages")
    private long numberOfpages;
	
	@Version
	@Column(name = "version")
	private long version;
}
