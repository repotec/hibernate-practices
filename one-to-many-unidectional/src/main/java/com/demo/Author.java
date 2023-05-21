package com.demo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
public class Author {
	@Id
	@Column(name = "author_id")
	private long autherId;
	
	@Column(name = "author_name")
	private String autherName;
	
	@OneToMany(mappedBy = "author")
	private List<Book> books;
}
