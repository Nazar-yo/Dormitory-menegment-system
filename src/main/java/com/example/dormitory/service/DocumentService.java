package com.example.dormitory.service;

import java.io.InputStream;
import java.util.List;
import com.example.dormitory.dto.DocumentRequestDto;
import com.example.dormitory.model.Document;

public interface DocumentService {
    Document create(DocumentRequestDto requestDto);

    void savePhoto(Long id, InputStream inputStream);

    Document getById(Long id);

    List<Document> findByApplicantId(Long applicantId);

    InputStream getPhotoById(Long id);
}
