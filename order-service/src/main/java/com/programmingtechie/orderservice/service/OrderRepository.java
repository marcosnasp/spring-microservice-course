package com.programmingtechie.orderservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programmingtechie.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
