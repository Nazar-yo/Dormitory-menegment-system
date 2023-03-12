package com.example.dormitory.mapper;

import com.example.dormitory.dto.InventoryItemResponseDto;
import com.example.dormitory.model.InventoryItem;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemMapper implements ResponseDtoMapper<InventoryItemResponseDto, InventoryItem> {
    @Override
    public InventoryItemResponseDto mapToDto(InventoryItem inventoryItem) {
        InventoryItemResponseDto responseDto = new InventoryItemResponseDto();
        responseDto.setInventoryType(inventoryItem.getInventoryType());
        responseDto.setResidentId(inventoryItem.getResident().getId());
        responseDto.setId(inventoryItem.getId());

        return responseDto;
    }
}
