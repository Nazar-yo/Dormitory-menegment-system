package com.example.dormitory.dto;

import lombok.Data;

@Data
public class DocumentResponseDto {
    private Long id;
    private Long applicantId;
    private String documentType;
}
