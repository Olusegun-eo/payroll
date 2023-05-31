package com.emmanuel.payroll.web;

import com.emmanuel.payroll.dat.model.Benefit;
import com.emmanuel.payroll.service.benefit.BenefitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benefits")
public class BenefitController {

    private final BenefitService benefitService;

    public BenefitController(BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    @GetMapping
    public ResponseEntity<List<Benefit>> getAllBenefits() {
        List<Benefit> benefits = benefitService.getAllBenefits();
        return ResponseEntity.ok(benefits);
    }

    @PostMapping
    public ResponseEntity<Benefit> createBenefit(@RequestBody Benefit benefit) {
        Benefit createdBenefit = benefitService.createBenefit(benefit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBenefit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Benefit> getBenefitById(@PathVariable Long id) {
        Benefit benefit = benefitService.getBenefitById(id);
        if (benefit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(benefit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Benefit> updateBenefit(@PathVariable Long id, @RequestBody Benefit updatedBenefit) {
        Benefit benefit = benefitService.getBenefitById(id);
        if (benefit == null) {
            return ResponseEntity.notFound().build();
        }
        benefit.setName(updatedBenefit.getName());
        benefit.setAmount(updatedBenefit.getAmount());
        Benefit updated = benefitService.updateBenefit(benefit);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBenefit(@PathVariable Long id) {
        boolean deleted = benefitService.deleteBenefit(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
