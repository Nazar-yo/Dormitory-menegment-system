package com.example.dormitory.service;

import java.util.List;
import com.example.dormitory.model.Furniture;

public interface FurnitureService {
    List<Furniture> findByRoomId(Long roomId);
}
