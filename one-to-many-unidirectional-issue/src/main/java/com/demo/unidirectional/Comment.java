package com.demo.unidirectional;

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
@Table(name = "comments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "comment_id")
	private long commentId;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "post_id")
	private long postId;
	
}
