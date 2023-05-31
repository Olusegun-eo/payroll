package com.emmanuel.payroll.service.deduction;

import com.emmanuel.payroll.dat.model.Deduction;
import com.emmanuel.payroll.repository.DeductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeductionServiceImpl implements DeductionService{

    private final DeductionRepository deductionRepository;

    public DeductionServiceImpl(DeductionRepository deductionRepository) {
        this.deductionRepository = deductionRepository;
    }

    @Override
    public List<Deduction> getAllDeductions() {
        return deductionRepository.findAll();
    }

    @Override
    public Deduction getDeductionById(Long id) {
        return deductionRepository.findById(id).orElse(null);
    }

    @Override
    public Deduction createDeduction(Deduction deduction) {
        return deductionRepository.save(deduction);
    }

    @Override
    public Deduction updateDeduction(Deduction deduction) {
        return deductionRepository.save(deduction);
    }

    @Override
    public boolean deleteDeduction(Long id) {
        if (deductionRepository.existsById(id)) {
            deductionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
