package com.demo.junctiontable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "author_id")
	private long autherId;
	
	@Column(name = "author_name")
	private String autherName;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	@Builder.Default
	private Set<Book> books = new HashSet<>();
}
