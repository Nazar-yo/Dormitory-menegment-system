package com.example.dormitory.dto;

import com.example.dormitory.model.enums.DormitoryType;
import lombok.Data;

@Data
public class DormitoryRequestDto {
    private Integer dormitoryNumber;
    private String address;
    private DormitoryType dormitoryType;
    private String contacts;
    private String faculties;
    private String photo;
}
