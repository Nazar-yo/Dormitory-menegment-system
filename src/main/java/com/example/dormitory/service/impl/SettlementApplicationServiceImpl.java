package com.example.dormitory.service.impl;

import java.util.List;
import com.example.dormitory.dto.SettlementApplicationRequestDto;
import com.example.dormitory.mapper.SettlementApplicationMapper;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.SettlementApplication;
import com.example.dormitory.repository.SettlementApplicationRepository;
import com.example.dormitory.service.RoomService;
import com.example.dormitory.service.SettlementApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SettlementApplicationServiceImpl implements SettlementApplicationService {
    private final SettlementApplicationRepository repository;
    private final RoomService roomService;
    private final SettlementApplicationMapper mapper;

    public SettlementApplicationServiceImpl(SettlementApplicationRepository repository, RoomService roomService, SettlementApplicationMapper mapper) {
        this.repository = repository;
        this.roomService = roomService;
        this.mapper = mapper;
    }

    @Override
    public SettlementApplication create(SettlementApplicationRequestDto requestDto) {
        Room room = roomService.getById(requestDto.getRoomId());
        SettlementApplication settlementApplication = mapper.mapToModel(requestDto);
        settlementApplication.setRoom(room);

        return repository.save(settlementApplication);
    }

    @Override
    public SettlementApplication getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing id: " + id));
    }

    @Override
    public List<SettlementApplication> getAll() {
        return repository.findAll();
    }
}
