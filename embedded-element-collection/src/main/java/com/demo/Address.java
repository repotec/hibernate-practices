package com.demo;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
