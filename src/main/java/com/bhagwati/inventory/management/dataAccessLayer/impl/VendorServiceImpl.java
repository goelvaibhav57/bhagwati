package com.bhagwati.inventory.management.dataAccessLayer.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.bhagwati.inventory.management.dataAccessLayer.VendorService;
import com.bhagwati.inventory.management.entity.Vendor;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	@Override
	public Mono<Vendor> createVendor(Vendor vendor) {
		vendor.setCreatedDate(new Date());
		Mono<Vendor> response = reactiveMongoTemplate.save(vendor,  "vendor");
		return response;
	}

	@Override
	public Flux<Vendor> getAllVendors() {
		return reactiveMongoTemplate.findAll(Vendor.class,"vendor");
		}

	@Override
	public Flux<Vendor> getVendorByVendorId(String vendorId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("vendorId").is(vendorId));
		return reactiveMongoTemplate.find(query, Vendor.class,"vendor");
	}

	@Override
	public Mono<Vendor> updateVendorDetails(String vendorId, Vendor vendor) {
		Query query = new Query();
        query.addCriteria(Criteria.where("vendorId").is(vendorId));
        Update update = new Update();
        update.set("vendorId", vendor.getVendorId());
        update.set("vendorDescription", vendor.getVendorDescription());
        update.set("lastUpdated", new Date());
		Mono<Vendor> response = reactiveMongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true), Vendor.class, "vendor");
		return response;
	}

	@Override
	public Mono<DeleteResult> deleteVendor(String vendorId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("vendorId").is(vendorId));
		Mono<DeleteResult> response = reactiveMongoTemplate.remove(query, Object.class, "vendor");
		return response;
	}

	
	

}
