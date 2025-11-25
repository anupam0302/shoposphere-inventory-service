package com.shoposphere.inventory.service;

import com.shoposphere.inventory.dto.InventoryResponse;
import com.shoposphere.inventory.dto.UpdateStockRequest;

public interface InventoryService {

    InventoryResponse getStock(String sku);

    InventoryResponse addStock(UpdateStockRequest request);

    InventoryResponse reduceStock(UpdateStockRequest request);
}
