package com.bhagwati.inventory.management.dataAccessLayer;

import com.bhagwati.inventory.management.entity.Vendor;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VendorService {

	Mono<Vendor> createVendor(Vendor vendor);

	Flux<Vendor> getAllVendors();

	Flux<Vendor> getVendorByVendorId(String vendorId);

	Mono<Vendor> updateVendorDetails(String vendorId, Vendor vendor);

	Mono<DeleteResult> deleteVendor(String id);


}
