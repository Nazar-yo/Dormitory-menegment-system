package com.example.dormitory.service;

import com.example.dormitory.dto.ApplicantRequestDto;
import com.example.dormitory.model.Applicant;

public interface ApplicantService {
    Applicant create(ApplicantRequestDto applicantRequestDto);

    Applicant update(Long id, ApplicantRequestDto applicantRequestDto);

    Applicant getById(Long id);

    Applicant findByEmail(String email);
}
