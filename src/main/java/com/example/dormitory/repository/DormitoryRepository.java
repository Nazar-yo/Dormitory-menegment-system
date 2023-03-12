package com.example.dormitory.repository;

import java.io.InputStream;
import java.util.Optional;
import com.example.dormitory.model.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DormitoryRepository extends JpaRepository<Dormitory, Long> {
    @Query(value = "update dormitory.dormitory d set d.dormitory_photo = ?2 where dormitory_id = ?1", nativeQuery = true)
    void saveFile(Long dormitoryId, InputStream photo);

    @Query(value = "select d.dormitory_photo from dormitory.dormitory d where dormitory_id = ?1", nativeQuery = true)
    Optional<InputStream> getPhotoById(Long id);
}
