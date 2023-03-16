package com.example.dormitory.controller;

import java.util.stream.Collectors;
import com.example.dormitory.dto.InventoryItemResponseDto;
import com.example.dormitory.mapper.InventoryItemMapper;
import com.example.dormitory.service.InventoryItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resident")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = {"Authorization", "Content-Type"},
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE}
)
public class ResidentController {
    private final InventoryItemService inventoryItemService;
    private final InventoryItemMapper inventoryItemMapper;

    public ResidentController(InventoryItemService inventoryItemService, InventoryItemMapper inventoryItemMapper) {
        this.inventoryItemService = inventoryItemService;
        this.inventoryItemMapper = inventoryItemMapper;
    }

    @GetMapping("/{applicant_id}/inventory_items")
    public InventoryItemResponseDto[] findByApplicantId(@PathVariable("applicant_id") Long applicantId) {
        return inventoryItemService.findByApplicantId(applicantId).stream()
                .map(inventoryItemMapper::mapToDto)
                .collect(Collectors.toList())
                .toArray(InventoryItemResponseDto[]::new);
    }
}
