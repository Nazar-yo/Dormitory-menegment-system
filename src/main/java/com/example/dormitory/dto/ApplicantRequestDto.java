package com.example.dormitory.dto;

import javax.validation.constraints.Size;
import com.example.dormitory.lib.ValidEmail;
import com.example.dormitory.lib.ValidPhone;
import com.example.dormitory.model.enums.Gender;
import lombok.Data;

@Data
public class ApplicantRequestDto {
    private String firstName;
    private String lastName;
    private String patronymic;
    @ValidPhone
    private String phoneNumber;
    @ValidEmail
    private String email;
    @Size(min = 8, max = 40)
    private String password;
    private String faculty;
    private String group;
    private Gender gender;
}
