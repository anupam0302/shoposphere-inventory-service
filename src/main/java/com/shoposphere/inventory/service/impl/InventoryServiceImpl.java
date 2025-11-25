package com.shoposphere.inventory.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoposphere.exception.ProductNotAvailableException;
import com.shoposphere.inventory.dto.InventoryResponse;
import com.shoposphere.inventory.dto.UpdateStockRequest;
import com.shoposphere.inventory.entity.InventoryItem;
import com.shoposphere.inventory.repository.InventoryRepository;
import com.shoposphere.inventory.service.InventoryService;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	private final InventoryRepository repository;

	public InventoryServiceImpl(InventoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public InventoryResponse getStock(String sku) {
		InventoryItem item = repository.findBySku(sku)
				.orElseThrow(() -> new ProductNotAvailableException("SKU not found: " + sku));

		return new InventoryResponse(item.getSku(), item.getAvailableQty());
	}

	@Override
	public InventoryResponse addStock(UpdateStockRequest request) {
		InventoryItem item = repository.findBySku(request.getSku()).orElse(new InventoryItem(request.getSku(), 0));

		item.addStock(request.getQty());
		repository.save(item);

		return new InventoryResponse(item.getSku(), item.getAvailableQty());
	}

	@Override
	public InventoryResponse reduceStock(UpdateStockRequest request) {
		InventoryItem item = repository.findBySku(request.getSku())
				.orElseThrow(() -> new ProductNotAvailableException("SKU not found: " + request.getSku()));

		item.reduceStock(request.getQty());
		repository.save(item);

		return new InventoryResponse(item.getSku(), item.getAvailableQty());
	}
}
