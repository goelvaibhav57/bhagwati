package com.bhagwati.inventory.management.dataAccessLayer.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.bhagwati.inventory.management.dataAccessLayer.SupplierService;
import com.bhagwati.inventory.management.entity.Supplier;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	@Override
	public Mono<Supplier> createSupplier(Supplier supplier) {
		supplier.setCreatedDate(new Date());
		Mono<Supplier> response = reactiveMongoTemplate.save(supplier,  "supplier");
		return response;
	}

	@Override
	public Flux<Supplier> getAllSuppliers() {
		return reactiveMongoTemplate.findAll(Supplier.class,"supplier");
		}

	@Override
	public Flux<Supplier> getSupplierBySupplierId(String supplierId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("supplierId").is(supplierId));
		return reactiveMongoTemplate.find(query, Supplier.class,"supplier");
	}

	@Override
	public Mono<Supplier> updateSupplierDetails(String supplierId, Supplier supplier) {
		Query query = new Query();
        query.addCriteria(Criteria.where("supplierId").is(supplierId));
        Update update = new Update();
        update.set("supplierId", supplier.getSupplierId());
        update.set("supplierDescription", supplier.getSupplierDescription());
        update.set("lastUpdated", new Date());
		Mono<Supplier> response = reactiveMongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true), Supplier.class, "supplier");
		return response;
	}

	@Override
	public Mono<DeleteResult> deleteSupplier(String supplierId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("supplierId").is(supplierId));
		Mono<DeleteResult> response = reactiveMongoTemplate.remove(query, Object.class, "supplier");
		return response;
	}

	
	

}
