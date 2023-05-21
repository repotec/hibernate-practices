package com.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	@Column(name = "book_id")
	private long bookId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author_id")
	private long authorId;
	
	//unidirectional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
}
