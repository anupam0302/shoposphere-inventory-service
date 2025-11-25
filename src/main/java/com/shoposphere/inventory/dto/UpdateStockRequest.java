package com.shoposphere.inventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UpdateStockRequest {

	@NotBlank
	private String sku;

	@Min(1)
	private int qty;

	public UpdateStockRequest(String sku, int qty) {
		this.sku = sku;
		this.qty = qty;
	}

	public String getSku() {
		return sku;
	}

	public int getQty() {
		return qty;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
