package com.bhagwati.inventory.management.dataAccessLayer.impl;

import java.io.IOException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import com.bhagwati.inventory.management.dataAccessLayer.ReactiveMongoConn;
import com.bhagwati.inventory.management.entity.Item;
import com.bhagwati.inventory.management.entity.Vendor;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public class ReactiveMongoConnImpl implements ReactiveMongoConn{
//	
//	@Autowired
//	private ReactiveMongoTemplate reactiveMongoTemplate;
//	
//	@Autowired
//    private GridFsTemplate gridFsTemplate;
//
//	@Override
//	public Flux<Item> getAllInventory() {
//		//Query query = new Query();
//        //query.addCriteria(Criteria.where("size.uom").is("tr"));
//        //Flux<Inventory> response = reactiveMongoTemplate.find(query, Inventory.class, "newinventory1");
//		Flux<Item> response = reactiveMongoTemplate.findAll(Item.class, "inventoryManagement");
//		return response;
//	}
//
//	@Override
//	public String uploadImage(MultipartFile file) throws IOException {
//		DBObject metaData = new BasicDBObject(); 
//        metaData.put("type", "video"); 
//        metaData.put("title", "test"); 
//        ObjectId id = gridFsTemplate.store(
//          file.getInputStream(), file.getName(), file.getContentType(), metaData); 
//        return id.toString();	
//        }
//
//	@Override
//	public GridFsResource getImage(String id) {
//		GridFSFile dbFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
//		GridFsResource file = gridFsTemplate.getResource(dbFile);
//		return file;
//	}
//
//	@Override
//	public Mono<Object> getInventoryById(String id) {
//		return reactiveMongoTemplate.findById(id, Object.class, "inventoryManagement");
//	}
//
//	@Override
//	public Flux<Item> getInventoryByName(String name) {
//		Query query = new Query();
//        query.addCriteria(Criteria.where("name").is(name));
//		return reactiveMongoTemplate.find(query, Item.class,"inventoryManagement");
//	}
//	
//	@Override
//	public Flux<Vendor> getAllVendors() {
//		// TODO Auto-generated method stub
//		return reactiveMongoTemplate.findAll(Vendor.class, "vendorManagement");
//	}
//
//	@Override
//	public Mono<Object> getVendorById(String id) {
//		return reactiveMongoTemplate.findById(id, Object.class, "vendorManagement");
//	}
//
//	@Override
//	public Mono<DeleteResult> deleteItem(String id) {
//		Query query = new Query();
//        query.addCriteria(Criteria.where("_id").is(id));
//		Mono<DeleteResult> response = reactiveMongoTemplate.remove(query, Object.class, "inventoryManagement");
//		return response;
//	}
//
//	@Override
//	public Mono<DeleteResult> deleteVendor(String id) {
//		Query query = new Query();
//        query.addCriteria(Criteria.where("_id").is(id));
//		Mono<DeleteResult> response = reactiveMongoTemplate.remove(query, Object.class, "vendorManagement");
//		return response;
//	}
//
//	@Override
//	public Mono<Item> updateInventoryById(String id, Item items) {
//		Query query = new Query();
//        query.addCriteria(Criteria.where("_id").is(id));
//        Update update = new Update();
//        update.set("itemCode", items.getItemCode());
//        update.set("description", items.getDescription());
//        update.set("currentInventory", items.getCurrentInventory());
//        update.set("lastUpdated", items.getLastUpdated());
//		Mono<Item> response = reactiveMongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true), Item.class, "item");
//		return response;
//	}
//
//	@Override
//	public Mono<Item> createInventoryById(Item items) {
//		Mono<Item> response = reactiveMongoTemplate.save(items,  "item");
//		return response;
//	}
//
//	
//	
//	
//
}
