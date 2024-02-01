package com.demo.embedded.collection.collections_embedded;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clerks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Clerk {
    @Id
    @Column(name = "clerk_id_pk")
    private Long clerkIdPk;

    @Column(name = "name")
    private String name;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "jobs", joinColumns = @JoinColumn(name = "clerk_id_fk"))
    private Set<Job> jobs;
    // no-args constructor getters and setters
}
