package com.example.dormitory.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.dormitory.dto.Pages;
import com.example.dormitory.dto.RoomRequestDto;
import com.example.dormitory.dto.RoomResponseDto;
import com.example.dormitory.mapper.PageMapper;
import com.example.dormitory.mapper.RoomMapper;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.enums.DormitoryType;
import com.example.dormitory.model.enums.Gender;
import com.example.dormitory.service.FurnitureService;
import com.example.dormitory.service.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    private final FurnitureService furnitureService;
    private final RoomMapper roomMapper;
    private final PageMapper pageMapper;

    public RoomController(RoomService roomService, FurnitureService furnitureService, RoomMapper roomMapper, PageMapper pageMapper) {
        this.roomService = roomService;
        this.furnitureService = furnitureService;
        this.roomMapper = roomMapper;
        this.pageMapper = pageMapper;
    }

    @GetMapping
    public Pages<RoomResponseDto> getAll(@RequestParam(defaultValue = "20") Integer count,
                                         @RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "id") String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);

        Page<Room> pages = roomService.getAll(pageRequest);

        return mapContent(pages, false);
    }

    @GetMapping("/{id}")
    public RoomResponseDto getById(@PathVariable("id") Long id) {
        return roomMapper.mapToDto(roomService.getById(id));
    }

    @PutMapping
    public RoomResponseDto create(@RequestBody RoomRequestDto roomRequestDto) {
        return roomMapper.mapToDto(roomService.create(roomRequestDto));
    }

    @GetMapping("/{furniture_info}/available")
    public Pages<RoomResponseDto> getFreeRoomsByGenderAndDormitoryType(@RequestParam Gender gender,
                                                                       @PathVariable("furniture_info") boolean furnitureInfo,
                                                                       @RequestParam(required = false) Long dormitoryId,
                                                                       @RequestParam(required = false) DormitoryType dormitoryType,
                                                                       @RequestParam(defaultValue = "20") Integer count,
                                                                       @RequestParam(defaultValue = "0") Integer page,
                                                                       @RequestParam(defaultValue = "id") String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);

        Page<Room> pages = roomService.getFreeRooms(gender, dormitoryId ,dormitoryType, pageRequest);

        return mapContent(pages, furnitureInfo);
    }

    private Pages<RoomResponseDto> mapContent(Page<Room> pages, boolean furnitureInfo) {
        Pages<RoomResponseDto> roomPages = pageMapper.mapToPage(pages);
        List<RoomResponseDto> content = pages.getContent().stream()
                .map(roomMapper::mapToDto)
                .collect(Collectors.toList());

        if(furnitureInfo) {
            content.forEach(dto -> dto.setFurniture(furnitureService.findByRoomId(dto.getId())));
        }

        roomPages.setContent(content);
        return roomPages;
    }
}
