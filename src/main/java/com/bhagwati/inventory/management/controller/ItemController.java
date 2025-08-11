package com.bhagwati.inventory.management.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhagwati.inventory.management.dataAccessLayer.ItemService;
import com.bhagwati.inventory.management.entity.Item;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
public class ItemController {

	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@PostMapping("/create/item")
	public Mono<Item> createItem(@RequestBody Item item){
		Mono<Item> response = itemService.createItem(item);
		return response;
	}
	
	@GetMapping("/item/{itemCode}")
	public Flux<Item> getItemByItemCode(@PathVariable String itemCode) {
		Flux<Item> response = itemService.getItemByItemCode(itemCode);
		return response;
	}
	
	@GetMapping("/item/all")
	public Flux<Item> getAllItems() {
		Flux<Item> response = itemService.getAllItems();
		return response;
	}
	
	@PutMapping("/update/item/{itemCode}")
	public Mono<Item> updateItem(@PathVariable String itemCode, @RequestBody Item item){
		Mono<Item> response = itemService.updateItemDetails(itemCode,item);
		return response;
	}
	
	@DeleteMapping("delete/item/{itemCode}")
	public Mono<DeleteResult> deleteItem(@PathVariable String itemCode){
		return itemService.deleteItem(itemCode);
	}

}
