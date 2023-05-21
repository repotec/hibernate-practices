package com.demo;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {
	private String street;
    private String city;
    private String country;
    private String zipCode;
}
