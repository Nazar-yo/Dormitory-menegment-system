package com.example.dormitory.dto;

import com.example.dormitory.model.enums.Gender;
import lombok.Data;

@Data
public class RoomRequestDto {
    private Long dormitoryId;
    private String roomNumber;
    private Integer capacity;
    private Integer residents_number;
    private Gender gender;
}
