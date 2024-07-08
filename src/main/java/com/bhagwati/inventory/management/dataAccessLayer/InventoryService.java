package com.bhagwati.inventory.management.dataAccessLayer;

import java.math.BigInteger;

import com.bhagwati.inventory.management.entity.Inventory;
import com.bhagwati.inventory.management.entity.Item;
import com.bhagwati.inventory.management.entity.Supplier;
import com.bhagwati.inventory.management.entity.Vendor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryService {

	Flux<Inventory> getInventoryByItemCode(String itemCode);

	Mono<Inventory> addInventory(String itemCode, Inventory inventory);

	Mono<Inventory> debitInventory(String itemCode, Inventory inventory);

	Mono<UpdateResult> updateInventoryItem(String itemCode, Item item);

	Mono<UpdateResult> updateInventoryVendor(String vendorId, Vendor vendor);

	Mono<UpdateResult> updateInventorySupplier(String supplierId, Supplier supplier);

	Mono<DeleteResult> deleteInventory(String itemCode);
	
}
