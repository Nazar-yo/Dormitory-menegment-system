package com.example.dormitory.service;

import java.io.InputStream;
import com.example.dormitory.dto.DormitoryRequestDto;
import com.example.dormitory.model.Dormitory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DormitoryService {
    Dormitory create(DormitoryRequestDto dormitory);

    Page<Dormitory> findAll(PageRequest pageRequest);

    Dormitory getById(Long id);
}
