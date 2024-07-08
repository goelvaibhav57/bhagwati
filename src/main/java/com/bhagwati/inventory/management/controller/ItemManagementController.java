package com.bhagwati.inventory.management.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhagwati.inventory.management.dataAccessLayer.ReactiveMongoConn;
import com.bhagwati.inventory.management.entity.Item;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@CrossOrigin(value = "http://localhost:4200")
public class ItemManagementController {
//
//
//	private ReactiveMongoConn mongoConn;
//	
//	public ItemManagementController(ReactiveMongoConn mongoConn) {
//		super();
//		this.mongoConn = mongoConn;
//	}
//
//	@GetMapping("/inventory/all")
//	public Flux<Item> getAllItem() {
//		Flux<Item> response = mongoConn.getAllInventory();
//		return response;
//	}
//	
//	@GetMapping("/inventory/id/{id}")
//	public Mono<Object> getItemById(@PathVariable String id) {
//		Mono<Object> response = mongoConn.getInventoryById(id);
//		return response;
//	}
//	
//	@PutMapping("/update/inventory/id/{id}")
//	public Mono<Item> updateInventory(@PathVariable String id, @RequestBody Item items){
//		Mono<Item> response = mongoConn.updateInventoryById(id,items);
//		return response;
//	}
//	@PostMapping("/create/inventory")
//	public Mono<Item> createInventory(@RequestBody Item items){
//		Mono<Item> response = mongoConn.createInventoryById(items);
//		return response;
//	}
//	@GetMapping("/inventory/name/{name}")
//	public Flux<Item> getItemByName(@PathVariable String name) {
//		Flux<Item> response = mongoConn.getInventoryByName(name);
//		return response;
//	}
//	
//	@DeleteMapping("delete/items/id/{id}")
//	public Mono<DeleteResult> deleteItem(@PathVariable String id){
//		return mongoConn.deleteItem(id);
//	}
}
