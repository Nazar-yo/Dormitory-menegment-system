package com.example.dormitory.service;

import com.example.dormitory.dto.RoomRequestDto;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.enums.DormitoryType;
import com.example.dormitory.model.enums.Gender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RoomService {
    Page<Room> getAll(PageRequest pageRequest);

    Room create(RoomRequestDto roomRequestDto);

    Room getById(Long id);

    Page<Room> getFreeRoomsByGender(Gender gender, PageRequest pageRequest);

    Page<Room> getFreeRoomsByGenderAndDormitory(Gender gender, Long dormitoryId, PageRequest pageRequest);

    Page<Room> getFreeRoomsByGenderAndDormitoryType(Gender gender, DormitoryType dormitoryType, PageRequest pageRequest);
}
