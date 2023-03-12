package com.example.dormitory.dto;

import com.example.dormitory.model.enums.Gender;
import lombok.Data;

@Data
public class RoomResponseDto {
    private Long id;
    private DormitoryResponseDto dormitory;
    private String roomNumber;
    private Integer capacity;
    private Integer residents_number;
    private Gender gender;
}
