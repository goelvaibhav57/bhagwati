package com.bhagwati.inventory.management.controller;

import java.math.BigInteger;

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
	
	@GetMapping("/inventory/itemCode/{itemCode}")
	public Flux<Inventory> getItemByItemCode(@PathVariable String itemCode) {
		Flux<Inventory> response = inventoryService.getInventoryByItemCode(itemCode);
		return response;
	}
	
	@PutMapping("/inventory/add/{itemCode}")
	public Mono<Inventory> addInventory(@PathVariable String itemCode, @RequestBody Inventory inventory){
		Mono<Inventory> response = inventoryService.addInventory(itemCode,inventory);
		return response;
	}
	
	@PutMapping("/inventory/debit/{itemCode}")
	public Mono<Inventory> debitInventory(@PathVariable String itemCode, @RequestBody Inventory inventory){
		Mono<Inventory> response = inventoryService.debitInventory(itemCode,inventory);
		return response;
	}
	
	@DeleteMapping("/inventory/delete/{itemCode}")
	public Mono<DeleteResult> deleteInventory(@PathVariable String itemCode){
		Mono<DeleteResult> response = inventoryService.deleteInventory(itemCode);
		return response;
	}

	@PutMapping("/inventory/update/item/{itemCode}")
	public Mono<UpdateResult> updateInventoryItem(@PathVariable String itemCode, @RequestBody Item item){
		Mono<UpdateResult> response = inventoryService.updateInventoryItem(itemCode, item);
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
