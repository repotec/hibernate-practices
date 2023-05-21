package com.demo.bidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item {
	@Id
	@Column(name = "item_id")
	private Long itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@ManyToOne
    @JoinColumn(name = "fk_order_id")
    private PurchaseOrder order;
}
