package com.project.re_mind.repository;



import com.project.re_mind.model.AssetCategory;
import com.project.re_mind.model.AssetCoverage;
import com.project.re_mind.model.CoverageType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AssetCoverageRepository extends JpaRepository<AssetCoverage, Long> {
    List<AssetCoverage> findByOwnerNameIgnoreCase(String ownerName);
    List<AssetCoverage> findByCoverageType(CoverageType coverageType);
    List<AssetCoverage> findByCategory(AssetCategory category);
    List<AssetCoverage> findByProviderIgnoreCase(String provider);

    // Example: expiring before a date
    List<AssetCoverage> findByStartDateBefore(LocalDate date);
}