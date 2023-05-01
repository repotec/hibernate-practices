package com.demo.subquery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {
	@Id
	@Column(name = "ORDER_ID")
    private Long orderId;

	@Column(name = "PRODUCT_NAME")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
