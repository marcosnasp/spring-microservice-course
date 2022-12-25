package com.programmingtechie.orderservice.dto;

import java.math.BigDecimal;

public record OrderLineItemsDto(String skuOrder, BigDecimal price, Integer quantity) {

}
