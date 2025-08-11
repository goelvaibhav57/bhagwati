package com.bhagwati.inventory.management.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("item")
public class Item {
	@Indexed(unique = true)
	private String itemCode;
	private String itemDescription;
	private Integer warehouseNumber;
	private Date createdDate;
	private Date lastUpdated;
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public Integer getWarehouseNumber() {
		return warehouseNumber;
	}
	public void setWarehouseNumber(Integer warehouseNumber) {
		this.warehouseNumber = warehouseNumber;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Item(String itemCode, String itemDescription, Integer warehouseNumber, Date createdDate, Date lastUpdated) {
		super();
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
		this.warehouseNumber = warehouseNumber;
		this.createdDate = createdDate;
		this.lastUpdated = lastUpdated;
	}
	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", itemDescription=" + itemDescription + ", warehouseNumber="
				+ warehouseNumber + ", createdDate=" + createdDate + ", lastUpdated=" + lastUpdated + "]";
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
