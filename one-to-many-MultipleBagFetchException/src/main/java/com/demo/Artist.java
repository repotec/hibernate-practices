package com.demo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "artist")
@Getter
@Setter
@ToString
public class Artist {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private List<Song> songs;

    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private List<Offer> offers;
}
