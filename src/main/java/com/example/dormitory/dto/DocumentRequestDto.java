package com.example.dormitory.dto;

import java.io.InputStream;
import lombok.Data;

@Data
public class DocumentRequestDto {
    private Long applicantId;
    private String documentType;
}
