package com.example.dormitory.dto;

import java.util.List;
import com.example.dormitory.model.Furniture;
import com.example.dormitory.model.enums.Gender;
import lombok.Data;

@Data
public class RoomResponseDto {
    private Long id;
    private Long dormitoryId;
    private Integer dormitoryNumber;
    private String roomNumber;
    private Integer capacity;
    private Integer residents_number;
    private Gender gender;
    private List<Furniture> furniture;
}
