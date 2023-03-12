package com.example.dormitory.repository;

import java.io.InputStream;
import java.util.Optional;
import com.example.dormitory.model.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DormitoryRepository extends JpaRepository<Dormitory, Long> {
}
