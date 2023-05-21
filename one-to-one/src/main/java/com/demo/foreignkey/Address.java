package com.demo.foreignkey;

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
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "city")
    private String city;
    
    @OneToOne(mappedBy = "address")
    private User user;
}