package com.example.dormitory.repository;

import java.util.List;
import com.example.dormitory.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    List<InventoryItem> getInventoryItemsByResident_Id(Long residentId);

    List<InventoryItem> getInventoryItemsByResidentApplicantId(Long applicantId);
}
