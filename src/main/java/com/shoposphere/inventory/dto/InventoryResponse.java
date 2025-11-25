package com.shoposphere.inventory.dto;

public class InventoryResponse {

    private String sku;
    private int availableQty;

    public InventoryResponse(String sku, int availableQty) {
        this.sku = sku;
        this.availableQty = availableQty;
    }

    public String getSku() {
        return sku;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

}
