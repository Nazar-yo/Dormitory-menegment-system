package com.example.dormitory.model;

import java.util.List;
import com.example.dormitory.model.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
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
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
}
