package com.demo.embedded.single.nested_embedded;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Company {
    @Id
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;

    private String address;

    @Embedded
    private ContactPerson contactPerson;
}