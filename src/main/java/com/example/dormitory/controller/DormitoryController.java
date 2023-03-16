package com.example.dormitory.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Collectors;
import com.example.dormitory.dto.DormitoryRequestDto;
import com.example.dormitory.dto.DormitoryResponseDto;
import com.example.dormitory.dto.Pages;
import com.example.dormitory.mapper.DormitoryMapper;
import com.example.dormitory.mapper.PageMapper;
import com.example.dormitory.model.Dormitory;
import com.example.dormitory.service.DormitoryService;
import org.apache.commons.io.IOUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dormitory")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = {"Authorization", "Content-Type"},
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE}
)
public class DormitoryController {
    private final DormitoryService dormitoryService;
    private final DormitoryMapper dormitoryMapper;
    private final PageMapper pageMapper;

    public DormitoryController(DormitoryService dormitoryService, DormitoryMapper dormitoryMapper,
                               PageMapper pageMapper) {
        this.dormitoryService = dormitoryService;
        this.dormitoryMapper = dormitoryMapper;
        this.pageMapper = pageMapper;
    }


    @GetMapping
    public Pages<DormitoryResponseDto> getAll(@RequestParam(defaultValue = "20") Integer count,
                                              @RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "id") String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);

        Page<Dormitory> pages = dormitoryService.findAll(pageRequest);
        Pages<DormitoryResponseDto> dormitoryPages = pageMapper.mapToPage(pages);
        dormitoryPages.setContent(pages.getContent().stream()
                .map(dormitoryMapper::mapToDto)
                .collect(Collectors.toList()));

        return dormitoryPages;
    }

    @GetMapping("/{id}")
    public DormitoryResponseDto getById(@PathVariable("id") Long id) {
        return dormitoryMapper.mapToDto(dormitoryService.getById(id));
    }

    @PutMapping
    public DormitoryResponseDto create(@RequestBody DormitoryRequestDto dormitoryRequestDto) {
        return dormitoryMapper.mapToDto(dormitoryService.create(dormitoryRequestDto));
    }
}
