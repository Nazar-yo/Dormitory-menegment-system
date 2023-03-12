package com.example.dormitory.dto;

import com.example.dormitory.model.enums.InventoryType;
import lombok.Data;

@Data
public class InventoryItemResponseDto {
    private Long id;
    private Long residentId;
    private InventoryType inventoryType;
}
