package com.example.dormitory.model;

import com.example.dormitory.model.enums.DormitoryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "dormitory")
public class Dormitory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dormitory_id")
    private Long id;
    private Integer dormitoryNumber;
    private String address;
    @Enumerated(value = EnumType.STRING)
    private DormitoryType dormitoryType;
    private String contacts;
    private String faculties;
    private String photo;
}
