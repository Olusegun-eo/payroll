package com.emmanuel.payroll.web;


import com.emmanuel.payroll.dat.model.CadreLevel;
import com.emmanuel.payroll.service.cadreservice.CadreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadre-levels")
public class CadreController {

    private final CadreService cadreService;

    public CadreController(CadreService cadreService) {
        this.cadreService = cadreService;
    }

    @GetMapping
    public ResponseEntity<List<CadreLevel>> getAllCadreLevels() {
        List<CadreLevel> cadreLevels = cadreService.getAllCadreLevels();
        return ResponseEntity.ok(cadreLevels);
    }

    @PostMapping
    public ResponseEntity<CadreLevel> createCadreLevel(@RequestBody CadreLevel cadreLevel) {
        CadreLevel createdCadreLevel = cadreService.createCadreLevel(cadreLevel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCadreLevel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadreLevel> getCadreLevelById(@PathVariable Long id) {
        CadreLevel cadreLevel = cadreService.getCadreLevelById(id);
        if (cadreLevel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cadreLevel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadreLevel> updateCadreLevel(@PathVariable Long id, @RequestBody CadreLevel updatedCadreLevel) {
        CadreLevel cadreLevel = cadreService.getCadreLevelById(id);
        if (cadreLevel == null) {
            return ResponseEntity.notFound().build();
        }
        cadreLevel.setName(updatedCadreLevel.getName());
        cadreLevel.setBonus(updatedCadreLevel.getBonus());
        CadreLevel updated = cadreService.updateCadreLevel(cadreLevel);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCadreLevel(@PathVariable Long id) {
        boolean deleted = cadreService.deleteCadreLevel(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
