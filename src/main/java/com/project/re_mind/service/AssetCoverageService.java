package com.project.re_mind.service;

import com.project.re_mind.model.AssetCategory;
import com.project.re_mind.model.AssetCoverage;
import com.project.re_mind.model.CoverageType;
import com.project.re_mind.repository.AssetCoverageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetCoverageService {


    private final AssetCoverageRepository repository;

    public AssetCoverageService(AssetCoverageRepository repository) {
        this.repository = repository;
    }

    public List<AssetCoverage> getAll() {
        return repository.findAll();
    }

    public Optional<AssetCoverage> getById(Long id) {
        return repository.findById(id);
    }

    public List<AssetCoverage> getByOwner(String ownerName) {
        return repository.findByOwnerNameIgnoreCase(ownerName);
    }

    public List<AssetCoverage> getByType(CoverageType type) {
        return repository.findByCoverageType(type);
    }

    public List<AssetCoverage> getByCategory(AssetCategory category) {
        return repository.findByCategory(category);
    }

    public List<AssetCoverage> getByProvider(String provider) {
        return repository.findByProviderIgnoreCase(provider);
    }

    public AssetCoverage save(AssetCoverage coverage) {
        return repository.save(coverage);
    }

    public AssetCoverage update(Long id, AssetCoverage incoming) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setOwnerName(incoming.getOwnerName());
                    existing.setAssetName(incoming.getAssetName());
                    existing.setProvider(incoming.getProvider());
                    existing.setCoverageType(incoming.getCoverageType());
                    existing.setCategory(incoming.getCategory());
                    existing.setStartDate(incoming.getStartDate());
                    existing.setDurationMonths(incoming.getDurationMonths());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException("Coverage not found: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
