package com.demo.join;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Getter
@Setter
public class Book {
	@Id
	@Column(name = "BOOK_ID")
	private String bookId;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
}
