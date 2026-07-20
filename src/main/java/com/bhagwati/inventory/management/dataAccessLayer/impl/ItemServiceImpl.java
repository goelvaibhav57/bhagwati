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
import com.bhagwati.inventory.management.entity.DatabaseSequence;
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
		item.setItemId(getSequenceId("item_id_seq"));
		
		Mono<Item> response = reactiveMongoTemplate.save(item,  "item");
		return response;
	}

	private Long getSequenceId(String itemId) {
		return reactiveMongoTemplate.findAndModify(
				Query.query(Criteria.where("_id").is(itemId)),
				new Update().inc("seq", 1),
				FindAndModifyOptions.options().returnNew(true).upsert(true),
				DatabaseSequence.class).map(seq -> seq.getSeq()).block();
	}

	@Override
	public Flux<Item> getItemByItemId(Long itemId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("itemId").is(itemId));
		return reactiveMongoTemplate.find(query, Item.class,"item");
	}

	@Override
	public Flux<Item> getAllItems() {
		return reactiveMongoTemplate.findAll(Item.class,"item");
	}

	@Override
	public Mono<Item> updateItemDetails(Long itemId, Item item) {
		Query itemQuery = new Query();
		itemQuery.addCriteria(Criteria.where("itemId").is(itemId));
        Update updateItem = new Update();
        	updateItem.set("itemDescription", item.getItemDescription());
			updateItem.set("itemCode", item.getItemCode());
			updateItem.set("warehouseNumber", item.getWarehouseNumber());
        updateItem.set("lastUpdated", new Date());
		Mono<Item> response = reactiveMongoTemplate.findAndModify(itemQuery, updateItem,new FindAndModifyOptions().returnNew(true), Item.class, "item");
		
		return response;
	}

	@Override
	public Mono<DeleteResult> deleteItem(Long itemId) {
		Query itemQuery = new Query();
		itemQuery.addCriteria(Criteria.where("itemId").is(itemId));
		Mono<DeleteResult> response = reactiveMongoTemplate.remove(itemQuery, Object.class, "item");
		Query inventoryQuery = new Query();
		inventoryQuery.addCriteria(Criteria.where("item.itemId").is(itemId));
		reactiveMongoTemplate.remove(inventoryQuery, Inventory.class, "inventory");
		return response;
	}
	

}
