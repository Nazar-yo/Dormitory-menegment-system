package com.example.dormitory.service.impl;

import java.util.List;
import com.example.dormitory.model.Furniture;
import com.example.dormitory.repository.FurnitureRepository;
import com.example.dormitory.service.FurnitureService;
import org.springframework.stereotype.Service;

@Service
public class FurnitureServiceImpl implements FurnitureService {
    private final FurnitureRepository repository;

    public FurnitureServiceImpl(FurnitureRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Furniture> findByRoomId(Long roomId) {
        return repository.getFurnituresByRoom_Id(roomId);
    }
}
