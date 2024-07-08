package com.bhagwati.inventory.management.dataAccessLayer;

import com.bhagwati.inventory.management.entity.Item;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemService {

	Mono<Item> createItem(Item item);

	Flux<Item> getItemByItemCode(String itemCode);

	Flux<Item> getAllItems();

	Mono<Item> updateItemDetails(String itemCode, Item item);

	Mono<DeleteResult> deleteItem(String itemCode);

}
