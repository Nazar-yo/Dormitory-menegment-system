package com.example.dormitory.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Collectors;
import com.example.dormitory.dto.DocumentRequestDto;
import com.example.dormitory.dto.DocumentResponseDto;
import com.example.dormitory.mapper.DocumentMapper;
import com.example.dormitory.service.DocumentService;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document")
public class DocumentController {
    private final DocumentService documentService;
    private final DocumentMapper documentMapper;

    public DocumentController(DocumentService documentService, DocumentMapper documentMapper) {
        this.documentService = documentService;
        this.documentMapper = documentMapper;
    }

    @GetMapping("/{applicant_id}")
    public DocumentResponseDto[] findByApplicantId(@PathVariable(name = "applicant_id") Long applicantId) {
        return documentService.findByApplicantId(applicantId).stream()
                .map(documentMapper::mapToDto)
                .collect(Collectors.toList())
                .toArray(DocumentResponseDto[]::new);
    }

    @GetMapping("/{id}")
    public DocumentResponseDto getById(@PathVariable Long id) {
        return documentMapper.mapToDto(documentService.getById(id));
    }

    @GetMapping(value = "/{id}/photo", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getPhotoById(@PathVariable("id") Long id) throws IOException {
        return IOUtils.toByteArray(documentService.getPhotoById(id));
    }

    @PutMapping
    public DocumentResponseDto create(@RequestBody DocumentRequestDto documentRequestDto) {
        return documentMapper.mapToDto(documentService.create(documentRequestDto));
    }

    @PutMapping("/{id}/photo")
    public HttpResponseStatus savePhoto (@PathVariable Long id,
                                         @RequestBody InputStream inputStream) {
        documentService.savePhoto(id, inputStream);

        return HttpResponseStatus.ACCEPTED;
    }
}
