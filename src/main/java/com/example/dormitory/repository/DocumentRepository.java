package com.example.dormitory.repository;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import com.example.dormitory.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findDocumentsByApplicant_Id(Long applicantId);

    @Query(value = "update dormitory.applicant_document d set d.document = ?2 where document_id = ?1", nativeQuery = true)
    void saveFile(Long dormitoryId, InputStream photo);

    @Query(value = "select d.document from dormitory.applicant_document d where document_id = ?1", nativeQuery = true)
    Optional<InputStream> getPhotoById(Long id);
}
