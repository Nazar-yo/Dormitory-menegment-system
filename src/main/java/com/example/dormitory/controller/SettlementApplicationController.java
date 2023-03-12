package com.example.dormitory.controller;

import java.util.stream.Collectors;
import com.example.dormitory.dto.SettlementApplicationRequestDto;
import com.example.dormitory.dto.SettlementApplicationResponseDto;
import com.example.dormitory.mapper.SettlementApplicationMapper;
import com.example.dormitory.service.SettlementApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settlement-application")
public class SettlementApplicationController {
    private final SettlementApplicationService service;
    private final SettlementApplicationMapper mapper;

    public SettlementApplicationController(SettlementApplicationService service, SettlementApplicationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @PutMapping("/create")
    public SettlementApplicationResponseDto create(@RequestBody SettlementApplicationRequestDto requestDto) {
        return mapper.mapToDto(service.create(requestDto));
    }

    @GetMapping("/{id}")
    public SettlementApplicationResponseDto getById(@PathVariable("id") Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @GetMapping
    public SettlementApplicationResponseDto[] getAll() {
        return service.getAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList())
                .toArray(SettlementApplicationResponseDto[]::new);
    }
}
