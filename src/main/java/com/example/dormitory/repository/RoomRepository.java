package com.example.dormitory.repository;

import com.example.dormitory.model.Room;
import com.example.dormitory.model.enums.DormitoryType;
import com.example.dormitory.model.enums.Gender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "from Room r where r.gender = ?1 and r.capacity > r.residents_number")
    Page<Room> findRoomsByGender(Gender gender, PageRequest pageRequest);

    @Query(value = "from Room r where r.gender = ?1 and r.dormitory.id = ?2 and r.capacity > r.residents_number")
    Page<Room> findRoomsByGenderAndDormitory(Gender gender, Long dormitoryId, PageRequest pageRequest);

    @Query(value = "from Room r where r.gender = ?1 and r.dormitory.dormitoryType = ?2 and r.capacity > r.residents_number")
    Page<Room> findRoomsByGenderAndDormitoryType(Gender gender, DormitoryType dormitoryType, PageRequest pageRequest);
}
