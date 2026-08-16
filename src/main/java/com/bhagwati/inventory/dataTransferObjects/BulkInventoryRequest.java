package com.bhagwati.inventory.dataTransferObjects;

public class BulkInventoryRequest {
    private Long itemId;
    private Integer inventoryCredited;
    private String supplierId;
    private String comments;

    public BulkInventoryRequest() {
    }

    public BulkInventoryRequest(Long itemId, Integer inventoryCredited, String supplierId, String comments) {
        this.itemId = itemId;
        this.inventoryCredited = inventoryCredited;
        this.supplierId = supplierId;
        this.comments = comments;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getInventoryCredited() {
        return inventoryCredited;
    }

    public void setInventoryCredited(Integer inventoryCredited) {
        this.inventoryCredited = inventoryCredited;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
