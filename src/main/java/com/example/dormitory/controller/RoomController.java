package com.example.dormitory.controller;

import java.util.stream.Collectors;
import com.example.dormitory.dto.Pages;
import com.example.dormitory.dto.RoomRequestDto;
import com.example.dormitory.dto.RoomResponseDto;
import com.example.dormitory.mapper.PageMapper;
import com.example.dormitory.mapper.RoomMapper;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.enums.DormitoryType;
import com.example.dormitory.model.enums.Gender;
import com.example.dormitory.service.RoomService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    private final RoomMapper roomMapper;
    private final PageMapper pageMapper;

    public RoomController(RoomService roomService, RoomMapper roomMapper, PageMapper pageMapper) {
        this.roomService = roomService;
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

        return mapContent(pages);
    }

    @GetMapping
    public RoomResponseDto getById(@PathParam("id") Long id) {
        return roomMapper.mapToDto(roomService.getById(id));
    }

    @PutMapping
    public RoomResponseDto create(@RequestBody RoomRequestDto roomRequestDto) {
        return roomMapper.mapToDto(roomService.create(roomRequestDto));
    }

    @GetMapping("/available")
    public Pages<RoomResponseDto> getFreeRoomsByGender(@RequestParam Gender gender,
                                                      @RequestParam(defaultValue = "20") Integer count,
                                                      @RequestParam(defaultValue = "0") Integer page,
                                                      @RequestParam(defaultValue = "id") String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);

        Page<Room> pages = roomService.getFreeRoomsByGender(gender, pageRequest);

        return mapContent(pages);
    }

    @GetMapping("/available")
    public Pages<RoomResponseDto> getFreeRoomsByGenderAndDormitory(@RequestParam Gender gender,
                                                       @RequestParam Long dormitoryId,
                                                       @RequestParam(defaultValue = "20") Integer count,
                                                       @RequestParam(defaultValue = "0") Integer page,
                                                       @RequestParam(defaultValue = "id") String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);

        Page<Room> pages = roomService.getFreeRoomsByGenderAndDormitory(gender, dormitoryId, pageRequest);

        return mapContent(pages);
    }

    @GetMapping("/available")
    public Pages<RoomResponseDto> getFreeRoomsByGenderAndDormitoryType(@RequestParam Gender gender,
                                                                       @RequestParam DormitoryType dormitoryType,
                                                                       @RequestParam(defaultValue = "20") Integer count,
                                                                       @RequestParam(defaultValue = "0") Integer page,
                                                                       @RequestParam(defaultValue = "id") String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);

        Page<Room> pages = roomService.getFreeRoomsByGenderAndDormitoryType(gender, dormitoryType, pageRequest);

        return mapContent(pages);
    }

    private Pages<RoomResponseDto> mapContent(Page<Room> pages) {
        Pages<RoomResponseDto> roomPages = pageMapper.mapToPage(pages);
        roomPages.setContent(pages.getContent().stream()
                .map(roomMapper::mapToDto)
                .collect(Collectors.toList()));
        return roomPages;
    }
}
