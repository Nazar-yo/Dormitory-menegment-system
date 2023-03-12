package com.example.dormitory.service.impl;

import com.example.dormitory.dto.ApplicantRequestDto;
import com.example.dormitory.mapper.ApplicantMapper;
import com.example.dormitory.model.Applicant;
import com.example.dormitory.repository.ApplicantRepository;
import com.example.dormitory.service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository, ApplicantMapper applicantMapper) {
        this.applicantRepository = applicantRepository;
        this.applicantMapper = applicantMapper;
    }

    @Override
    public Applicant create(ApplicantRequestDto applicantRequestDto) {
        return applicantRepository.save(applicantMapper.mapToModel(applicantRequestDto));
    }

    @Override
    public Applicant update(Long id, ApplicantRequestDto applicantRequestDto) {
        Applicant applicant;
        if (applicantRepository.existsById(id)) {
            applicant = applicantMapper.mapToModel(applicantRequestDto);
            applicant.setId(id);
            applicant = applicantRepository.save(applicant);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing id: " + id);
        }

        return applicant;
    }

    @Override
    public Applicant getById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing id: " + id));
    }
}
