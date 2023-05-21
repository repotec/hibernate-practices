package com.demo.bidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "purchase_orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PurchaseOrder {

	@Id
	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "total_price")
	private Long totalPrice;
	
	@OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<Item>();
}
