package com.emmanuel.payroll.service.deduction;

import com.emmanuel.payroll.dat.model.Deduction;

import java.util.List;

public interface DeductionService {

    List<Deduction> getAllDeductions();

    Deduction createDeduction(Deduction deduction);

    Deduction getDeductionById(Long id);

    Deduction updateDeduction(Deduction deduction);

    boolean deleteDeduction(Long id);
}

