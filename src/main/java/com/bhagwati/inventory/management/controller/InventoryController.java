package com.bhagwati.inventory.management.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhagwati.inventory.management.dataAccessLayer.InventoryService;
import com.bhagwati.inventory.management.entity.Inventory;
import com.bhagwati.inventory.management.entity.Item;
import com.bhagwati.inventory.management.entity.Supplier;
import com.bhagwati.inventory.management.entity.Vendor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@CrossOrigin(value = "http://localhost:4200")
public class InventoryController {

	private InventoryService inventoryService;
	
	public InventoryController(InventoryService inventoryService) {
		super();
		this.inventoryService = inventoryService;
	}
	
	@GetMapping("/inventory/itemId/{itemId}")
	public Flux<Inventory> getItemByItemId(@PathVariable Long itemId) {
		Flux<Inventory> response = inventoryService.getInventoryByItemId(itemId);
		return response;
	}
	
	@PutMapping("/inventory/add/{itemId}")
	public Mono<Inventory> addInventory(@PathVariable Long itemId, @RequestBody Inventory inventory){
		Mono<Inventory> response = inventoryService.addInventory(itemId,inventory);
		return response;
	}
	
	@PutMapping("/inventory/debit/{itemId}")
	public Mono<Inventory> debitInventory(@PathVariable Long itemId, @RequestBody Inventory inventory){
		Mono<Inventory> response = inventoryService.debitInventory(itemId,inventory);
		return response;
	}
	
	@DeleteMapping("/inventory/delete/{itemId}")
	public Mono<DeleteResult> deleteInventory(@PathVariable Long itemId){
		Mono<DeleteResult> response = inventoryService.deleteInventory(itemId);
		return response;
	}

	@PutMapping("/inventory/update/item/{itemId}")
	public Mono<UpdateResult> updateInventoryItem(@PathVariable Long itemId, @RequestBody Item item){
		Mono<UpdateResult> response = inventoryService.updateInventoryItem(itemId, item);
		return response;
	}
	
	@PutMapping("/inventory/update/vendor/{vendorId}")
	public Mono<UpdateResult> updateInventoryVendor(@PathVariable String vendorId, @RequestBody Vendor vendor){
		Mono<UpdateResult> response = inventoryService.updateInventoryVendor(vendorId, vendor);
		return response;
	}
	
	@PutMapping("/inventory/update/supplier/{supplierId}")
	public Mono<UpdateResult> updateInventorySupplier(@PathVariable String supplierId, @RequestBody Supplier supplier){
		Mono<UpdateResult> response = inventoryService.updateInventorySupplier(supplierId, supplier);
		return response;
	}
	

}
