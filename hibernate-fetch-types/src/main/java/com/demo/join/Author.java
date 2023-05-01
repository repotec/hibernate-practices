package com.demo.join;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@Getter
@Setter
public class Author {
	@Id
	@Column(name = "AUTHOR_ID")
	private Integer authorId;
	
	@Column(name = "AUTHOR_NAME")
	private String authorName;
	
	@OneToMany(mappedBy = "author")
	@Fetch(FetchMode.JOIN)
	private Set<Book> books;
}
