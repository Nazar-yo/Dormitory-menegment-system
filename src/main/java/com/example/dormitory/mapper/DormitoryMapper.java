package com.example.dormitory.mapper;

import com.example.dormitory.dto.DormitoryRequestDto;
import com.example.dormitory.dto.DormitoryResponseDto;
import com.example.dormitory.model.Dormitory;
import org.springframework.stereotype.Component;

@Component
public class DormitoryMapper implements ResponseDtoMapper<DormitoryResponseDto, Dormitory>,
        RequestDtoMapper<DormitoryRequestDto, Dormitory>{

    @Override
    public Dormitory mapToModel(DormitoryRequestDto dto) {
        Dormitory dormitory = new Dormitory();
        dormitory.setDormitoryNumber(dto.getDormitoryNumber());
        dormitory.setAddress(dto.getAddress());
        dormitory.setDormitoryType(dto.getDormitoryType());
        dormitory.setContacts(dto.getContacts());
        dormitory.setFaculties(dto.getFaculties());

        return dormitory;
    }

    @Override
    public DormitoryResponseDto mapToDto(Dormitory dormitory) {
        DormitoryResponseDto dormitoryResponseDto = new DormitoryResponseDto();
        dormitoryResponseDto.setId(dormitory.getId());
        dormitoryResponseDto.setDormitoryNumber(dormitory.getDormitoryNumber());
        dormitoryResponseDto.setAddress(dormitory.getAddress());
        dormitoryResponseDto.setDormitoryType(dormitory.getDormitoryType());
        dormitoryResponseDto.setFaculties(dormitory.getFaculties());
        dormitoryResponseDto.setContacts(dormitory.getContacts());

        return dormitoryResponseDto;
    }
}
