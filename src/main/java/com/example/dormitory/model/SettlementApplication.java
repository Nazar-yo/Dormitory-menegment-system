package com.example.dormitory.model;

import java.time.LocalDateTime;
import com.example.dormitory.model.enums.ApplicationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "settlement_application")
public class SettlementApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;
    @JoinColumn(name = "desired_room_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
    private LocalDateTime creationDate;
    private LocalDateTime settlementStartDate;
    private LocalDateTime settlementEndDate;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;
}
