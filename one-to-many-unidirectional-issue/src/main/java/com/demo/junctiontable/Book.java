package com.demo.junctiontable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "book_id")
	private long bookId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author_id")
	private long authorId;
}
