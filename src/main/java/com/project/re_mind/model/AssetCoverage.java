package com.project.re_mind.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
public class AssetCoverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String ownerName;


    private String assetName;



    private String provider;


    @Enumerated(EnumType.STRING)
    private CoverageType coverageType;


    @Enumerated(EnumType.STRING)
    private AssetCategory category;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;


    private int durationMonths;


    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public LocalDate getEndDate() {
        if (startDate == null) return null;
        return startDate.plusMonths(durationMonths);
    }

    // Getters
    public String getOwnerName() { return ownerName; }
    public String getAssetName() { return assetName; }
    public String getProvider() { return provider; }
    public CoverageType getCoverageType() { return coverageType; }
    public AssetCategory getCategory() { return category; }
    public LocalDate getStartDate() { return startDate; }
    public int getDurationMonths() { return durationMonths; }

    // Setters
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public void setProvider(String provider) { this.provider = provider; }
    public void setCoverageType(CoverageType coverageType) { this.coverageType = coverageType; }
    public void setCategory(AssetCategory category) { this.category = category; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setDurationMonths(int durationMonths) { this.durationMonths = durationMonths; }


}

