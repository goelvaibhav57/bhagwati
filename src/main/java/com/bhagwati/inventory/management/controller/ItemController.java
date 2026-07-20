package com.bhagwati.inventory.management.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(value = "http://localhost:4200")
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
	
	@GetMapping("/item/{itemId}")
	public Flux<Item> getItemByItemId(@PathVariable Long itemId) {
		Flux<Item> response = itemService.getItemByItemId(itemId);
		return response;
	}
	
	@GetMapping("/item/all")
	public Flux<Item> getAllItems() {
		Flux<Item> response = itemService.getAllItems();
		return response;
	}
	
	@PutMapping("/update/item/{itemId}")
	public Mono<Item> updateItem(@PathVariable Long itemId, @RequestBody Item item){
		Mono<Item> response = itemService.updateItemDetails(itemId, item);
		return response;
	}
	
	@DeleteMapping("delete/item/{itemId}")
	public Mono<DeleteResult> deleteItem(@PathVariable Long itemId){
		return itemService.deleteItem(itemId);
	}

}
