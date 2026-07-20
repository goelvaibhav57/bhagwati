package com.bhagwati.inventory.management.dataAccessLayer.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.bhagwati.inventory.management.dataAccessLayer.InventoryService;
import com.bhagwati.inventory.management.dataAccessLayer.ItemService;
import com.bhagwati.inventory.management.entity.DatabaseSequence;
import com.bhagwati.inventory.management.entity.Inventory;
import com.bhagwati.inventory.management.entity.Item;
import com.bhagwati.inventory.management.entity.Supplier;
import com.bhagwati.inventory.management.entity.Vendor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;
	
	private ItemService itemService;
	
	public InventoryServiceImpl(ItemService itemService) {
		this.itemService = itemService;
	}

	@Override
	public Flux<Inventory> getInventoryByItemId(Long itemId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("item.itemId").is(itemId));
        query.with(Sort.by(Sort.Direction.DESC, "createdDate"));
		return reactiveMongoTemplate.find(query, Inventory.class,"inventory");
	}

	@Override
	public Mono<Inventory> addInventory(Long itemId, Inventory inventory) {
		Inventory newInventory =  new Inventory(); 
		Query query = new Query();
	    query.limit(1);
	    query.with(Sort.by(Sort.Direction.DESC, "createdDate"));
	    query.addCriteria(Criteria.where("item.itemId").is(itemId));
	    Flux<Inventory> latestInventoryResponse = reactiveMongoTemplate.find(query, Inventory.class,"inventory");
	    Inventory latestInventory = latestInventoryResponse.blockFirst();
		newInventory.setInventoryId(generateSequence("inventory_sequence"));
		Item item = itemService.getItemByItemId(itemId).blockFirst();
	    newInventory.setItem(item);
	    newInventory.setSupplier(inventory.getSupplier());
	    newInventory.setComments(inventory.getComments());
	    newInventory.setInventoryCredited(inventory.getInventoryCredited());
		newInventory.setCreatedDate(new Date());
		if(null != latestInventory) {
			newInventory.setCurrentInventory(latestInventory.getCurrentInventory() + inventory.getInventoryCredited());
		}
		else {
			newInventory.setCurrentInventory(inventory.getInventoryCredited());
			
		}
		Mono<Inventory> response = reactiveMongoTemplate.save(newInventory,  "inventory");
		return response;
	}

	@Override
	public Mono<Inventory> debitInventory(Long itemId, Inventory inventory) {
		Inventory newInventory =  new Inventory(); 
		Query query = new Query();
	    query.limit(1);
	    query.with(Sort.by(Sort.Direction.DESC, "createdDate"));
	    query.addCriteria(Criteria.where("item.itemId").is(itemId));
	    Flux<Inventory> latestInventoryResponse = reactiveMongoTemplate.find(query, Inventory.class,"inventory");
	    Inventory latestInventory = latestInventoryResponse.blockFirst();
	    newInventory.setInventoryId(generateSequence("inventory_sequence"));
	    Item item = itemService.getItemByItemId(itemId).blockFirst();
	    newInventory.setItem(item);
	    newInventory.setVendor(inventory.getVendor());
	    newInventory.setCreatedDate(new Date());
	    newInventory.setComments(inventory.getComments());
	    newInventory.setCurrentInventory(latestInventory.getCurrentInventory() - inventory.getInventoryDebited());
	    newInventory.setInventoryDebited(inventory.getInventoryDebited());
		Mono<Inventory> response = reactiveMongoTemplate.save(newInventory,  "inventory");
		return response;
	}

	@Override
	public Mono<DeleteResult> deleteInventory(Long itemId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("item.itemId").is(itemId));
		Mono<DeleteResult> response = reactiveMongoTemplate.remove(query, Object.class, "inventory");
		return response;
	}
	
	public long generateSequence(String seqName) {
		Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(seqName));
	    Mono<DatabaseSequence> counter = reactiveMongoTemplate.findAndModify(query,
	      new Update().inc("seq",1), new FindAndModifyOptions().returnNew(true).upsert(true),
	      DatabaseSequence.class);
	    return counter.block().getSeq();
	}
	
	@Override
	public Mono<UpdateResult> updateInventoryItem(Long itemId, Item item){
		Update updateInventory = new Update();
		Query inventoryQuery = new Query();
		inventoryQuery.addCriteria(Criteria.where("item.itemId").is(itemId));
		updateInventory.set("item.itemId", item.getItemId());
		updateInventory.set("item.itemDescription", item.getItemDescription());
		return reactiveMongoTemplate.updateMulti(inventoryQuery, updateInventory, Inventory.class, "inventory");
	}
	
	@Override
	public Mono<UpdateResult> updateInventoryVendor(String vendorId, Vendor vendor){
		Update updateInventory = new Update();
		Query inventoryQuery = new Query();
		inventoryQuery.addCriteria(Criteria.where("vendor.vendorId").is(vendorId));
		updateInventory.set("vendor.vendorId", vendor.getVendorId());
		updateInventory.set("vendor.vendorDescription", vendor.getVendorDescription());
		return reactiveMongoTemplate.updateMulti(inventoryQuery, updateInventory, Inventory.class, "inventory");
	}
	
	@Override
	public Mono<UpdateResult> updateInventorySupplier(String supplierId, Supplier supplier){
		Update updateInventory = new Update();
		Query inventoryQuery = new Query();
		inventoryQuery.addCriteria(Criteria.where("supplier.supplierId").is(supplierId));
		updateInventory.set("supplier.supplierId", supplier.getSupplierId());
		updateInventory.set("supplier.supplierDescription", supplier.getSupplierDescription());
		return reactiveMongoTemplate.updateMulti(inventoryQuery, updateInventory, Inventory.class, "inventory");
	}

}
