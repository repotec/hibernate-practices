package com.demo.embedded.collection.basiccollection_embedded;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "developers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Developer {
    @Id
    private Long id;
    private String name;

    @Embedded
    private Skills skills;
    // no-args constructor getters and setters
}
