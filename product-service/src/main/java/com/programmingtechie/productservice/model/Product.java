package com.programmingtechie.productservice.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "product")
public record Product(@Id String id, String name, String description, BigDecimal price) {
}
