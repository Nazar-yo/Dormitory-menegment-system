package com.example.dormitory.dto;

import com.example.dormitory.model.enums.Gender;
import lombok.Data;

@Data
public class ApplicantResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String phoneNumber;
    private String email;
    private String faculty;
    private Integer course;
    private Gender gender;
}
