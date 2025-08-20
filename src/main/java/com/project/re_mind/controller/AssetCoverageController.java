package com.project.re_mind.controller;


import com.project.re_mind.model.AssetCategory;
import com.project.re_mind.model.AssetCoverage;
import com.project.re_mind.model.CoverageType;
import com.project.re_mind.service.AssetCoverageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coverages")
public class AssetCoverageController {

    private final AssetCoverageService service;

    public AssetCoverageController(AssetCoverageService service) {
        this.service = service;
    }

    @GetMapping
    public List<AssetCoverage> getAllCoverages() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetCoverage> getCoverageById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/owner/{ownerName}")
    public List<AssetCoverage> getByOwner(@PathVariable String ownerName) {
        return service.getByOwner(ownerName);
    }

    @GetMapping("/type/{coverageType}")
    public List<AssetCoverage> getByType(@PathVariable CoverageType coverageType) {
        return service.getByType(coverageType);
    }

    @GetMapping("/category/{category}")
    public List<AssetCoverage> getByCategory(@PathVariable AssetCategory category) {
        return service.getByCategory(category);
    }

    @GetMapping("/provider/{provider}")
    public List<AssetCoverage> getByProvider(@PathVariable String provider) {
        return service.getByProvider(provider);
    }

    @PostMapping
    public ResponseEntity<AssetCoverage> create( @RequestBody AssetCoverage coverage) {
        return ResponseEntity.ok(service.save(coverage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetCoverage> update(@PathVariable Long id, @RequestBody AssetCoverage coverage) {
        return ResponseEntity.ok(service.update(id, coverage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
