package com.programmingtechie.orderservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String orderNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLineItems> orderLineItems;

	public Order() {
		super();
	}

	public Order(Long id, String orderNumber, List<OrderLineItems> orderLineItems) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderLineItems = orderLineItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderLineItems> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

}
