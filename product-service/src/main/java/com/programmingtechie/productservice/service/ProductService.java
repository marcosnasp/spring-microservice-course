package com.programmingtechie.productservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;
import com.programmingtechie.productservice.model.Product;
import com.programmingtechie.productservice.repository.ProductRepository;

@Service
public class ProductService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public void createProduct(ProductRequest productRequest) {
		Product product = new Product(null, productRequest.name(), productRequest.description(),
				productRequest.price());
		product = productRepository.save(product);
		LOGGER.info("Product is {} saved", product.id());
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products = this.productRepository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}

	private ProductResponse mapToProductResponse(Product product) {
		return new ProductResponse(product.id(), product.name(), product.description(), product.price());
	}
	
}
