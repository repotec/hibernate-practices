package com.demo.mappedbybidirectional;

import lombok.*;
import javax.persistence.*;

/**
 * Clerk entity is the owner in the one-to-one relationship
 */
@Entity
@Table(name = "clerks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clerk {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public void setJob(Job job) {
        if (job == null) {
            if (this.job != null) {
                this.job.setClerk(null);
            }
        } else {
            job.setClerk(this);
        }
        this.job = job;
    }
}