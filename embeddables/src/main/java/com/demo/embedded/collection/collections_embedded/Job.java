package com.demo.embedded.collection.collections_embedded;

import lombok.*;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Column(name="job_id_pk")
    private Long jobIdPk;
    private String title;

    // no-args constructor getters and setters
}
