package com.demo.unidirectionalJunctionTable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "author_id")
	private long authorId;
	
	@Column(name = "author_name")
	private String authorName;
	
	@OneToMany
	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
        this.books.add(book);
    }
}
