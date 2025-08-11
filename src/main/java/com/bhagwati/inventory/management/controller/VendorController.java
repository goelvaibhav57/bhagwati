package com.bhagwati.inventory.management.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhagwati.inventory.management.dataAccessLayer.VendorService;
import com.bhagwati.inventory.management.entity.Vendor;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VendorController {

private VendorService vendorService;
	
	public VendorController(VendorService vendorService) {
		super();
		this.vendorService = vendorService;
	}
	
	@PostMapping("/create/vendor")
	public Mono<Vendor> createVendor(@RequestBody Vendor vendor){
		Mono<Vendor> response = vendorService.createVendor(vendor);
		return response;
	}
	
	@GetMapping("/vendors/all")
	public Flux<Vendor> getAllVendors() {
		Flux<Vendor> response = vendorService.getAllVendors();
		return response;
	}
	
	@GetMapping("/vendor/{vendorId}")
	public Flux<Vendor> getVendorsById(@PathVariable String vendorId) {
		Flux<Vendor> response = vendorService.getVendorByVendorId(vendorId);
		return response;
	}
	
	@PutMapping("/update/vendor/{vendorId}")
	public Mono<Vendor> updateVendor(@PathVariable String vendorId, @RequestBody Vendor vendor){
		Mono<Vendor> response = vendorService.updateVendorDetails(vendorId,vendor);
		return response;
	}
	
	@DeleteMapping("delete/vendor/id/{id}")
	public Mono<DeleteResult> deleteItem(@PathVariable String id){
		return vendorService.deleteVendor(id);
	}
}
