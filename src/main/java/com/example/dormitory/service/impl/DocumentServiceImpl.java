package com.example.dormitory.service.impl;

import java.io.InputStream;
import java.util.List;
import com.example.dormitory.dto.DocumentRequestDto;
import com.example.dormitory.mapper.DocumentMapper;
import com.example.dormitory.model.Applicant;
import com.example.dormitory.model.Document;
import com.example.dormitory.repository.DocumentRepository;
import com.example.dormitory.service.ApplicantService;
import com.example.dormitory.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final ApplicantService applicantService;

    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentMapper documentMapper, ApplicantService applicantService) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
        this.applicantService = applicantService;
    }

    @Override
    public Document create(DocumentRequestDto requestDto) {
        Applicant applicant = applicantService.getById(requestDto.getApplicantId());
        Document document = documentMapper.mapToModel(requestDto);
        document.setApplicant(applicant);

        return documentRepository.save(document);

    }

    @Override
    public void savePhoto(Long id, InputStream inputStream) {
        documentRepository.saveFile(id, inputStream);
    }

    @Override
    public Document getById(Long id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing id: " + id));
    }

    @Override
    public List<Document> findByApplicantId(Long applicantId) {
        return documentRepository.findDocumentsByApplicant_Id(applicantId);
    }

    @Override
    public InputStream getPhotoById(Long id) {
        return documentRepository.getPhotoById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing id: " + id));
    }
}
