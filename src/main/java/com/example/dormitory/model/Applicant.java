package com.example.dormitory.model;

import com.example.dormitory.model.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private SettlementApplication settlementApplication;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private String faculty;
    private Integer course;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
}
