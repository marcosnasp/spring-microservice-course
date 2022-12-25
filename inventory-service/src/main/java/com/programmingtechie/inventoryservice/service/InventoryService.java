package com.programmingtechie.inventoryservice.service;

import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechie.inventoryservice.model.Inventory;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	
	public InventoryService(InventoryRepository inventoryRepository) {
		super();
		this.inventoryRepository = inventoryRepository;
	}

	@Transactional(readOnly = true)
	public boolean isInStock(String skuCode) {
		Optional<Inventory> inventory = inventoryRepository.findBySkuCode(skuCode);
		return (inventory.isPresent() ? true : false);
	}
	
}
