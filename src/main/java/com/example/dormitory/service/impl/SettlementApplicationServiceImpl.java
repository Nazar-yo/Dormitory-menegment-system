package com.example.dormitory.service.impl;

import java.util.List;

import com.example.dormitory.dto.SettlementApplicationRequestDto;
import com.example.dormitory.mapper.SettlementApplicationMapper;
import com.example.dormitory.model.Applicant;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.SettlementApplication;
import com.example.dormitory.repository.SettlementApplicationRepository;
import com.example.dormitory.service.ApplicantService;
import com.example.dormitory.service.RoomService;
import com.example.dormitory.service.SettlementApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SettlementApplicationServiceImpl implements SettlementApplicationService {
    private final SettlementApplicationRepository repository;
    private final RoomService roomService;
    private final ApplicantService applicantService;
    private final SettlementApplicationMapper mapper;

    public SettlementApplicationServiceImpl(SettlementApplicationRepository repository, RoomService roomService, ApplicantService applicantService, SettlementApplicationMapper mapper) {
        this.repository = repository;
        this.roomService = roomService;
        this.applicantService = applicantService;
        this.mapper = mapper;
    }

    @Override
    public SettlementApplication create(SettlementApplicationRequestDto requestDto) {
        Room room = null;
        if (requestDto.getRoomId() != null) {
            room = roomService.getById(requestDto.getRoomId());
        }
        Applicant applicant = applicantService.getById(requestDto.getApplicantId());
        SettlementApplication settlementApplication = mapper.mapToModel(requestDto);
        settlementApplication.setRoom(room);
        settlementApplication.setApplicant(applicant);

        return repository.save(settlementApplication);
    }

    @Override
    public SettlementApplication getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing id: " + id));
    }

    @Override
    public List<SettlementApplication> findByApplicantId(Long applicantId) {
        return repository.findSettlementApplicationsByApplicant_Id(applicantId);
    }
}
