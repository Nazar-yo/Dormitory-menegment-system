package com.example.dormitory.service;

import java.util.List;
import com.example.dormitory.model.InventoryItem;

public interface InventoryItemService {
    List<InventoryItem> findByResidentId(Long residentId);
}
