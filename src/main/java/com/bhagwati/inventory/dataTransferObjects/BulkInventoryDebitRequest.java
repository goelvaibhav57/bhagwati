package com.bhagwati.inventory.dataTransferObjects;

public class BulkInventoryDebitRequest {
    private Long itemId;
    private Integer inventoryDebited;
    private String vendorId;
    private String comments;

    public BulkInventoryDebitRequest() {
    }

    public BulkInventoryDebitRequest(Long itemId, Integer inventoryDebited, String vendorId, String comments) {
        this.itemId = itemId;
        this.inventoryDebited = inventoryDebited;
        this.vendorId = vendorId;
        this.comments = comments;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getInventoryDebited() {
        return inventoryDebited;
    }

    public void setInventoryDebited(Integer inventoryDebited) {
        this.inventoryDebited = inventoryDebited;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
