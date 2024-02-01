package com.demo.issue;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "order_id")
	private long id;
	
	@Column(name = "product_name")
	private String productName;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
