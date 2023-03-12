package com.example.dormitory.service;

import java.util.List;
import com.example.dormitory.dto.SettlementApplicationRequestDto;
import com.example.dormitory.model.SettlementApplication;

public interface SettlementApplicationService {
    SettlementApplication create(SettlementApplicationRequestDto requestDto);

    SettlementApplication getById(Long id);

    List<SettlementApplication> getAll();
}
