package com.programmingtechie.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechie.orderservice.dto.OrderLineItemsDto;
import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.model.OrderLineItems;

@Service
@Transactional
public class OrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.orderLineItemsDtoList()
				.stream()
				.map(this::mapToOrderLineItemsDto)
				.toList();
		
		order.setOrderLineItems(orderLineItems);
		order = orderRepository.save(order);
		LOGGER.info("Order {} - {} was saved successfully", order.getId(), order.getOrderNumber());
	}
	
	private OrderLineItems mapToOrderLineItemsDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.price());
		orderLineItems.setQuantity(orderLineItemsDto.quantity());
		orderLineItems.setSkuCode(orderLineItemsDto.skuOrder());
		return orderLineItems;
	}
}
