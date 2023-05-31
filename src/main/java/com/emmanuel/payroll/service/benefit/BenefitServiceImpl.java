package com.emmanuel.payroll.service.benefit;

import com.emmanuel.payroll.dat.model.Benefit;
import com.emmanuel.payroll.repository.BenefitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitServiceImpl implements BenefitService{

    private final BenefitRepository benefitRepository;

    public BenefitServiceImpl(BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    @Override
    public List<Benefit> getAllBenefits() {
        return benefitRepository.findAll();
    }

    @Override
    public Benefit getBenefitById(Long id) {
        return benefitRepository.findById(id).orElse(null);
    }

    @Override
    public Benefit createBenefit(Benefit benefit) {
        return benefitRepository.save(benefit);
    }

    @Override
    public Benefit updateBenefit(Benefit benefit) {
        return benefitRepository.save(benefit);
    }

    @Override
    public boolean deleteBenefit(Long id) {
        if (benefitRepository.existsById(id)) {
            benefitRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
