package com.example.dormitory.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.example.dormitory.dto.ApplicantRequestDto;
import com.example.dormitory.mapper.ApplicantMapper;
import com.example.dormitory.model.Applicant;
import com.example.dormitory.model.Role;
import com.example.dormitory.model.enums.RoleName;
import com.example.dormitory.repository.ApplicantRepository;
import com.example.dormitory.service.ApplicantService;
import com.example.dormitory.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository, ApplicantMapper applicantMapper,
                                RoleService roleService, BCryptPasswordEncoder passwordEncoder) {
        this.applicantRepository = applicantRepository;
        this.applicantMapper = applicantMapper;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Applicant create(ApplicantRequestDto applicantRequestDto) {
        Applicant applicant = applicantMapper.mapToModel(applicantRequestDto);

        Role role = roleService.getRoleByName(RoleName.USER);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        applicant.setRoles(roles);

        applicant.setPassword(passwordEncoder.encode(applicant.getPassword()));

        return applicantRepository.save(applicant);
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

    @Override
    public Applicant findByEmail(String email) {
        return applicantRepository.findApplicantByEmail(email);
    }
}
