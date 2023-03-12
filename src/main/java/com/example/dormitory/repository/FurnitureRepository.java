package com.example.dormitory.repository;

import java.util.List;
import com.example.dormitory.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    List<Furniture> getFurnituresByRoom_Id(Long roomId);
}
