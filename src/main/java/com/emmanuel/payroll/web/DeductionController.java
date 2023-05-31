package com.emmanuel.payroll.web;


import com.emmanuel.payroll.dat.model.Deduction;
import com.emmanuel.payroll.service.deduction.DeductionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deductions")
public class DeductionController {
    private final DeductionService deductionService;

    public DeductionController(DeductionService deductionService) {
        this.deductionService = deductionService;
    }

    @GetMapping
    public ResponseEntity<List<Deduction>> getAllDeductions() {
        List<Deduction> deductions = deductionService.getAllDeductions();
        return ResponseEntity.ok(deductions);
    }

    @PostMapping
    public ResponseEntity<Deduction> createDeduction(@RequestBody Deduction deduction) {
        Deduction createdDeduction = deductionService.createDeduction(deduction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDeduction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deduction> getDeductionById(@PathVariable Long id) {
        Deduction deduction = deductionService.getDeductionById(id);
        if (deduction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deduction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deduction> updateDeduction(@PathVariable Long id, @RequestBody Deduction updatedDeduction) {
        Deduction deduction = deductionService.getDeductionById(id);
        if (deduction == null) {
            return ResponseEntity.notFound().build();
        }
        deduction.setName(updatedDeduction.getName());
        deduction.setAmount(updatedDeduction.getAmount());
        Deduction updated = deductionService.updateDeduction(deduction);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeduction(@PathVariable Long id) {
        boolean deleted = deductionService.deleteDeduction(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
