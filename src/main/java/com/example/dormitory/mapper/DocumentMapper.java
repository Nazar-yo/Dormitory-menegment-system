package com.example.dormitory.mapper;

import com.example.dormitory.dto.DocumentRequestDto;
import com.example.dormitory.dto.DocumentResponseDto;
import com.example.dormitory.model.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper implements ResponseDtoMapper<DocumentResponseDto, Document>,
        RequestDtoMapper<DocumentRequestDto, Document>{
    @Override
    public Document mapToModel(DocumentRequestDto dto) {
        Document document = new Document();
        document.setDocumentType(dto.getDocumentType());

        return document;
    }

    @Override
    public DocumentResponseDto mapToDto(Document document) {
        DocumentResponseDto responseDto = new DocumentResponseDto();
        responseDto.setId(document.getId());
        responseDto.setApplicantId(document.getApplicant().getId());
        responseDto.setDocumentType(document.getDocumentType());

        return responseDto;
    }
}
