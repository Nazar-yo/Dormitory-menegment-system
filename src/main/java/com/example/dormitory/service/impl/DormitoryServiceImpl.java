package com.example.dormitory.service.impl;

import java.io.InputStream;
import com.example.dormitory.dto.DormitoryRequestDto;
import com.example.dormitory.mapper.DormitoryMapper;
import com.example.dormitory.model.Dormitory;
import com.example.dormitory.repository.DormitoryRepository;
import com.example.dormitory.service.DormitoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DormitoryServiceImpl implements DormitoryService {
    private final DormitoryRepository dormitoryRepository;
    private final DormitoryMapper dormitoryMapper;

    public DormitoryServiceImpl(DormitoryRepository dormitoryRepository, DormitoryMapper dormitoryMapper) {
        this.dormitoryRepository = dormitoryRepository;
        this.dormitoryMapper = dormitoryMapper;
    }

    @Override
    public Dormitory create(DormitoryRequestDto dormitory, InputStream dormitoryPhoto) {
        Dormitory dormitory1 = dormitoryRepository.save(dormitoryMapper.mapToModel(dormitory));

        dormitoryRepository.saveFile(dormitory1.getId(), dormitoryPhoto);

        return dormitory1;
    }

    @Override
    public Page<Dormitory> findAll(PageRequest pageRequest) {
        return dormitoryRepository.findAll(pageRequest);
    }

    @Override
    public Dormitory getById(Long id) {
        return dormitoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing id: " + id));
    }

    @Override
    public InputStream getPhotoById(Long id) {
        return dormitoryRepository.getPhotoById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing id: " + id));
    }
}
