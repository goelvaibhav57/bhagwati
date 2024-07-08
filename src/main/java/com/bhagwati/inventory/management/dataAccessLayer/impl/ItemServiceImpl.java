package com.bhagwati.inventory.management.dataAccessLayer.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.bhagwati.inventory.management.dataAccessLayer.ItemService;
import com.bhagwati.inventory.management.entity.Inventory;
import com.bhagwati.inventory.management.entity.Item;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	@Override
	public Mono<Item> createItem(Item item) {
		item.setCreatedDate(new Date());
		Mono<Item> response = reactiveMongoTemplate.save(item,  "item");
		return response;
	}

	@Override
	public Flux<Item> getItemByItemCode(String itemCode) {
		Query query = new Query();
        query.addCriteria(Criteria.where("itemCode").is(itemCode));
		return reactiveMongoTemplate.find(query, Item.class,"item");
	}

	@Override
	public Flux<Item> getAllItems() {
		return reactiveMongoTemplate.findAll(Item.class,"item");
	}

	@Override
	public Mono<Item> updateItemDetails(String itemCode, Item item) {
		Query itemQuery = new Query();
		itemQuery.addCriteria(Criteria.where("itemCode").is(itemCode));
        Update updateItem = new Update();
        	updateItem.set("itemCode", item.getItemCode());
        	updateItem.set("itemDescription", item.getItemDescription());
        updateItem.set("lastUpdated", new Date());
		Mono<Item> response = reactiveMongoTemplate.findAndModify(itemQuery, updateItem,new FindAndModifyOptions().returnNew(true), Item.class, "item");
		
		return response;
	}

	@Override
	public Mono<DeleteResult> deleteItem(String itemCode) {
		Query itemQuery = new Query();
		itemQuery.addCriteria(Criteria.where("itemCode").is(itemCode));
		Mono<DeleteResult> response = reactiveMongoTemplate.remove(itemQuery, Object.class, "item");
		Query inventoryQuery = new Query();
		inventoryQuery.addCriteria(Criteria.where("item.itemCode").is(itemCode));
		reactiveMongoTemplate.remove(inventoryQuery, Inventory.class, "inventory");
		return response;
	}
	

}
