package com.example.dormitory.dto;

import java.time.LocalDateTime;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.enums.ApplicationStatus;
import lombok.Data;

@Data
public class SettlementApplicationRequestDto {
    private Long roomId;
    private Long applicantId;
    private LocalDateTime creationDate;
    private LocalDateTime settlementStartDate;
    private LocalDateTime settlementEndDate;
    private ApplicationStatus applicationStatus;
}
