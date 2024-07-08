package com.bhagwati.inventory.management.entity;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("inventory")
@Getter
@Setter
public class Inventory {
	@Transient
    public static final String SEQUENCE_NAME = "inventory_sequence";
	@Id
	private long inventoryId;
	private Item item;
	private Vendor vendor;
	private Supplier supplier;
	private Integer currentInventory;
	private Integer inventoryCredited;
	private Integer inventoryDebited;
	private String comments;
	private Date createdDate;
	public long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Integer getCurrentInventory() {
		return currentInventory;
	}
	public void setCurrentInventory(Integer currentInventory) {
		this.currentInventory = currentInventory;
	}
	public Integer getInventoryCredited() {
		return inventoryCredited;
	}
	public void setInventoryCredited(Integer inventoryCredited) {
		this.inventoryCredited = inventoryCredited;
	}
	public Integer getInventoryDebited() {
		return inventoryDebited;
	}
	public void setInventoryDebited(Integer inventoryDebited) {
		this.inventoryDebited = inventoryDebited;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Inventory(long inventoryId, Item item, Vendor vendor, Supplier supplier, Integer currentInventory,
			Integer inventoryCredited, Integer inventoryDebited, String comments, Date createdDate) {
		super();
		this.inventoryId = inventoryId;
		this.item = item;
		this.vendor = vendor;
		this.supplier = supplier;
		this.currentInventory = currentInventory;
		this.inventoryCredited = inventoryCredited;
		this.inventoryDebited = inventoryDebited;
		this.comments = comments;
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", item=" + item + ", vendor=" + vendor + ", supplier="
				+ supplier + ", currentInventory=" + currentInventory + ", inventoryCredited=" + inventoryCredited
				+ ", inventoryDebited=" + inventoryDebited + ", comments=" + comments + ", createdDate=" + createdDate
				+ "]";
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
