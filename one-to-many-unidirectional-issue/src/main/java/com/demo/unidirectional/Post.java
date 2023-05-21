package com.demo.unidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "post_id")
	private long postId;
	
	@Column(name = "post_name")
	private String postName;
	
	@OneToMany(cascade = { CascadeType.PERSIST})
	@Builder.Default
	private Set<Comment> comments = new HashSet<>();
}
