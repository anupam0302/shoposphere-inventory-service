package com.shoposphere.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoposphere.inventory.dto.InventoryResponse;
import com.shoposphere.inventory.dto.UpdateStockRequest;
import com.shoposphere.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	private final InventoryService service;

	public InventoryController(InventoryService service) {
		this.service = service;
	}

	@GetMapping("/{sku}")
	public InventoryResponse getStock(@PathVariable String sku) {
		return service.getStock(sku);
	}

	@PostMapping("/add")
	public InventoryResponse addStock(@RequestBody UpdateStockRequest request) {
		return service.addStock(request);
	}

	@PostMapping("/reduce")
	public InventoryResponse reduceStock(@RequestBody UpdateStockRequest request) {
		return service.reduceStock(request);
	}
}
