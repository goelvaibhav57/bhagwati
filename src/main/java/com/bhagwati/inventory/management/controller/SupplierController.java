package com.bhagwati.inventory.management.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhagwati.inventory.management.dataAccessLayer.SupplierService;
import com.bhagwati.inventory.management.entity.Supplier;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
public class SupplierController {

private SupplierService supplierService;
	
	public SupplierController(SupplierService supplierService) {
		super();
		this.supplierService = supplierService;
	}
	
	@PostMapping("/create/supplier")
	public Mono<Supplier> createSupplier(@RequestBody Supplier supplier){
		Mono<Supplier> response = supplierService.createSupplier(supplier);
		return response;
	}
	
	@GetMapping("/suppliers/all")
	public Flux<Supplier> getAllSuppliers() {
		Flux<Supplier> response = supplierService.getAllSuppliers();
		return response;
	}
	
	@GetMapping("/supplier/{supplierId}")
	public Flux<Supplier> getSuppliersById(@PathVariable String supplierId) {
		Flux<Supplier> response = supplierService.getSupplierBySupplierId(supplierId);
		return response;
	}
	
	@PutMapping("/update/supplier/{supplierId}")
	public Mono<Supplier> updateSupplier(@PathVariable String supplierId, @RequestBody Supplier supplier){
		Mono<Supplier> response = supplierService.updateSupplierDetails(supplierId,supplier);
		return response;
	}
	
	@DeleteMapping("delete/supplier/id/{id}")
	public Mono<DeleteResult> deleteItem(@PathVariable String id){
		return supplierService.deleteSupplier(id);
	}
}
