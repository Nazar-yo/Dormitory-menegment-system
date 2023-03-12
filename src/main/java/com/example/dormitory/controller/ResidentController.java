package com.example.dormitory.controller;

import java.util.stream.Collectors;
import com.example.dormitory.dto.InventoryItemResponseDto;
import com.example.dormitory.mapper.InventoryItemMapper;
import com.example.dormitory.service.InventoryItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resident")
public class ResidentController {
    private final InventoryItemService inventoryItemService;
    private final InventoryItemMapper inventoryItemMapper;

    public ResidentController(InventoryItemService inventoryItemService, InventoryItemMapper inventoryItemMapper) {
        this.inventoryItemService = inventoryItemService;
        this.inventoryItemMapper = inventoryItemMapper;
    }

    @GetMapping("/{resident_id}/inventory_items")
    public InventoryItemResponseDto[] findByResidentId(@PathVariable("resident_id") Long residentId) {
        return inventoryItemService.findByResidentId(residentId).stream()
                .map(inventoryItemMapper::mapToDto)
                .collect(Collectors.toList())
                .toArray(InventoryItemResponseDto[]::new);
    }
}
