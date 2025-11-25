package com.shoposphere.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory_items")
public class InventoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String sku;

	@Column(nullable = false)
	private int availableQty;

	public InventoryItem() {
	}

	public InventoryItem(String sku, int availableQty) {
		this.sku = sku;
		this.availableQty = availableQty;
	}

	public Long getId() {
		return id;
	}

	public String getSku() {
		return sku;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public void addStock(int qty) {
		this.availableQty += qty;
	}

	public void reduceStock(int qty) {
		if (qty > availableQty)
			throw new IllegalArgumentException("Not enough stock");
		this.availableQty -= qty;
	}
}
