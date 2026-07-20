package com.bhagwati.inventory.management.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("vendor")
public class Vendor {
	@Indexed(unique = true)
	private String vendorId;
	private String vendorDescription;
	private Date lastUpdated;
	private Date createdDate;
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorDescription() {
		return vendorDescription;
	}
	public void setVendorDescription(String vendorDescription) {
		this.vendorDescription = vendorDescription;
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
		return "Vendor [vendorId=" + vendorId + ", vendorDescription=" + vendorDescription + ", lastUpdated="
				+ lastUpdated + ", createdDate=" + createdDate + "]";
	}
	public Vendor(String vendorId, String vendorDescription, Date lastUpdated, Date createdDate) {
		super();
		this.vendorId = vendorId;
		this.vendorDescription = vendorDescription;
		this.lastUpdated = lastUpdated;
		this.createdDate = createdDate;
	}
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
