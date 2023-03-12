package com.example.dormitory.service.impl;

import java.util.List;
import com.example.dormitory.model.InventoryItem;
import com.example.dormitory.repository.InventoryItemRepository;
import com.example.dormitory.service.InventoryItemService;
import org.springframework.stereotype.Service;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {
    private final InventoryItemRepository repository;

    public InventoryItemServiceImpl(InventoryItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InventoryItem> findByResidentId(Long residentId) {
        return repository.getInventoryItemsByResident_Id(residentId);
    }
}
