package com.demo.sharedprimarykey;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
	@Id
	@Column(name = "id")
    private Long id;
 
	@Column(name = "title")
    private String title;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "post")
    private PostDetails postDetails;
}
