package com.example.dormitory.mapper;

import com.example.dormitory.dto.RoomRequestDto;
import com.example.dormitory.dto.RoomResponseDto;
import com.example.dormitory.model.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements ResponseDtoMapper<RoomResponseDto, Room>,
        RequestDtoMapper<RoomRequestDto, Room> {

    @Override
    public Room mapToModel(RoomRequestDto dto) {
        Room room = new Room();
        room.setRoomNumber(dto.getRoomNumber());
        room.setCapacity(dto.getCapacity());
        room.setGender(dto.getGender());
        room.setResidents_number(dto.getResidents_number());

        return room;
    }

    @Override
    public RoomResponseDto mapToDto(Room room) {
        RoomResponseDto roomResponseDto = new RoomResponseDto();
        roomResponseDto.setRoomNumber(room.getRoomNumber());
        roomResponseDto.setCapacity(room.getCapacity());
        roomResponseDto.setGender(room.getGender());
        roomResponseDto.setResidents_number(room.getResidents_number());
        roomResponseDto.setId(room.getId());
        roomResponseDto.setDormitoryNumber(room.getDormitory().getDormitoryNumber());
        roomResponseDto.setDormitoryId(room.getDormitory().getId());

        return roomResponseDto;
    }
}
