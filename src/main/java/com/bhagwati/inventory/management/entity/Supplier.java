package com.bhagwati.inventory.management.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("supplier")
@Getter
@Setter
public class Supplier {
	@Indexed(unique = true)
	private String supplierId;
	private String supplierDescription;
	private Date lastUpdated;
	private Date createdDate;
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierDescription() {
		return supplierDescription;
	}
	public void setSupplierDescription(String supplierDescription) {
		this.supplierDescription = supplierDescription;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierDescription=" + supplierDescription + ", lastUpdated="
				+ lastUpdated + ", createdDate=" + createdDate + "]";
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(String supplierId, String supplierDescription, Date lastUpdated, Date createdDate) {
		super();
		this.supplierId = supplierId;
		this.supplierDescription = supplierDescription;
		this.lastUpdated = lastUpdated;
		this.createdDate = createdDate;
	}
	
	

}
