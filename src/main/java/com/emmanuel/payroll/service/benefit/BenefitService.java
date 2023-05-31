package com.emmanuel.payroll.service.benefit;

import com.emmanuel.payroll.dat.model.Benefit;

import java.util.List;

public interface BenefitService {
    List<Benefit> getAllBenefits();

    Benefit createBenefit(Benefit benefit);

    Benefit getBenefitById(Long id);

    Benefit updateBenefit(Benefit benefit);

    boolean deleteBenefit(Long id);
}
