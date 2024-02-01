package com.demo.mappedbybidirectional;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne(mappedBy = "job", cascade = CascadeType.PERSIST)
    private Clerk clerk;
}