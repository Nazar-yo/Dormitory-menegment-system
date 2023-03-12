package com.example.dormitory.mapper;

import com.example.dormitory.dto.ApplicantRequestDto;
import com.example.dormitory.dto.ApplicantResponseDto;
import com.example.dormitory.model.Applicant;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapper implements RequestDtoMapper<ApplicantRequestDto, Applicant>,
        ResponseDtoMapper<ApplicantResponseDto, Applicant> {
    @Override
    public Applicant mapToModel(ApplicantRequestDto dto) {
        Applicant applicant = new Applicant();
        applicant.setCourse(dto.getCourse());
        applicant.setEmail(dto.getEmail());
        applicant.setFaculty(dto.getFaculty());
        applicant.setGender(dto.getGender());
        applicant.setFirstName(dto.getFirstName());
        applicant.setLastName(dto.getLastName());
        applicant.setPatronymic(dto.getPatronymic());
        applicant.setPassword(dto.getPassword());
        applicant.setPhoneNumber(dto.getPhoneNumber());

        return applicant;
    }

    @Override
    public ApplicantResponseDto mapToDto(Applicant applicant) {
        return null;
    }
}
