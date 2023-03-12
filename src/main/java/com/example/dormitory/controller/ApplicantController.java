package com.example.dormitory.controller;

import com.example.dormitory.dto.ApplicantRequestDto;
import com.example.dormitory.dto.ApplicantResponseDto;
import com.example.dormitory.mapper.ApplicantMapper;
import com.example.dormitory.service.ApplicantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    private final ApplicantService applicantService;
    private final ApplicantMapper applicantMapper;

    public ApplicantController(ApplicantService applicantService, ApplicantMapper applicantMapper) {
        this.applicantService = applicantService;
        this.applicantMapper = applicantMapper;
    }

    @PutMapping("/register")
    public ApplicantResponseDto register(@RequestBody ApplicantRequestDto applicantRequestDto) {
        return applicantMapper.mapToDto(applicantService.create(applicantRequestDto));
    }

    @GetMapping("/{id}")
    public ApplicantResponseDto getById(@PathVariable("id") Long id) {
        return applicantMapper.mapToDto(applicantService.getById(id));
    }

    @PutMapping("/{id}/update")
    public ApplicantResponseDto update(@PathVariable("id") Long id,
                                       @RequestBody ApplicantRequestDto applicantRequestDto) {
        return applicantMapper.mapToDto(applicantService.update(id, applicantRequestDto));
    }
}
