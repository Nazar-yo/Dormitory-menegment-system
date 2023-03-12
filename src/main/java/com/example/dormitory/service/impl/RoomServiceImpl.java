package com.example.dormitory.service.impl;

import com.example.dormitory.dto.RoomRequestDto;
import com.example.dormitory.mapper.RoomMapper;
import com.example.dormitory.model.Dormitory;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.enums.DormitoryType;
import com.example.dormitory.model.enums.Gender;
import com.example.dormitory.repository.RoomRepository;
import com.example.dormitory.service.DormitoryService;
import com.example.dormitory.service.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final DormitoryService dormitoryService;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomMapper roomMapper, RoomRepository roomRepository, DormitoryService dormitoryService) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
        this.dormitoryService = dormitoryService;
    }

    @Override
    public Page<Room> getAll(PageRequest pageRequest) {
       return roomRepository.findAll(pageRequest);
    }

    @Override
    public Room create(RoomRequestDto roomRequestDto) {
        Dormitory dormitory = dormitoryService.getById(roomRequestDto.getDormitoryId());
        Room room = roomMapper.mapToModel(roomRequestDto);
        room.setDormitory(dormitory);
        return roomRepository.save(room);
    }

    @Override
    public Room getById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing id: " + id));
    }

    @Override
    public Page<Room> getFreeRoomsByGender(Gender gender, PageRequest pageRequest) {
        return roomRepository.findRoomsByGender(gender, pageRequest);
    }

    @Override
    public Page<Room> getFreeRoomsByGenderAndDormitory(Gender gender, Long dormitoryId, PageRequest pageRequest) {
        return roomRepository.findRoomsByGenderAndDormitory(gender, dormitoryId, pageRequest);
    }

    @Override
    public Page<Room> getFreeRoomsByGenderAndDormitoryType(Gender gender, DormitoryType dormitoryType, PageRequest pageRequest) {
        return roomRepository.findRoomsByGenderAndDormitoryType(gender, dormitoryType, pageRequest);
    }
}
