package com.demo.subquery;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
public class Customer {
	@Id
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

	@Column(name = "CUSTOMER_NAME")
	private String consumerName;
	
    @OneToMany(mappedBy = "customer")
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Order> orders = new HashSet<>();
}
