package com.example.dormitory.repository;

import java.util.List;
import com.example.dormitory.model.SettlementApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementApplicationRepository extends JpaRepository<SettlementApplication, Long> {
    List<SettlementApplication> findSettlementApplicationsByApplicant_Id(Long applicantId);
}
