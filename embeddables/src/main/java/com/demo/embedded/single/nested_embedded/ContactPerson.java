package com.demo.embedded.single.nested_embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactPerson {
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
        @AttributeOverride(name = "middleName", column = @Column(name = "middle_name")),
        @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    })
    private Name name;
    private String phone;
}
