package com.programmingtechie.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.programmingtechie.inventoryservice.model.Inventory;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventoryIphone = new Inventory();
			inventoryIphone.setSkuCode("iphone_13");
			inventoryIphone.setQuantity(100);
			
			Inventory inventoryLenovo = new Inventory();
			inventoryLenovo.setSkuCode("lenovo_yoga_13");
			inventoryLenovo.setQuantity(100);
			
			inventoryRepository.save(inventoryIphone);
			inventoryRepository.save(inventoryLenovo);
		};
	}

}
