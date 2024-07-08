package com.bhagwati.inventory.management.dataAccessLayer;

import com.bhagwati.inventory.management.entity.Supplier;
import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SupplierService {

	Mono<Supplier> createSupplier(Supplier vendor);

	Flux<Supplier> getAllSuppliers();

	Flux<Supplier> getSupplierBySupplierId(String vendorId);

	Mono<Supplier> updateSupplierDetails(String vendorId, Supplier vendor);

	Mono<DeleteResult> deleteSupplier(String id);


}
