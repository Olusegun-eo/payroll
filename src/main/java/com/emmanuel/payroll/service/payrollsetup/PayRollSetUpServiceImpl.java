package com.emmanuel.payroll.service.payrollsetup;

import com.emmanuel.payroll.dat.model.CadreLevel;
import com.emmanuel.payroll.dat.model.PayrollComponent;
import com.emmanuel.payroll.dat.model.PayrollComponentType;
import com.emmanuel.payroll.dat.model.Position;
import com.emmanuel.payroll.repository.CadreLevelRepository;
import com.emmanuel.payroll.repository.PayrollComponentRepository;
import com.emmanuel.payroll.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayRollSetUpServiceImpl {
    private final CadreLevelRepository cadreLevelRepository;
    private final PositionRepository positionRepository;
    private final PayrollComponentRepository payrollComponentRepository;

    public PayRollSetUpServiceImpl(CadreLevelRepository cadreLevelRepository, PositionRepository positionRepository,
                               PayrollComponentRepository payrollComponentRepository) {
        this.cadreLevelRepository = cadreLevelRepository;
        this.positionRepository = positionRepository;
        this.payrollComponentRepository = payrollComponentRepository;
    }

    public void setupCadreLevels() {
        // Create and save cadre levels
        CadreLevel cadreLevel1 = new CadreLevel("Level 1");
        CadreLevel cadreLevel2 = new CadreLevel("Level 2");
        cadreLevelRepository.saveAll(List.of(cadreLevel1, cadreLevel2));
    }

    public void setupPositions() {
        // Create and save positions
        Position position1 = new Position("Position 1");
        Position position2 = new Position("Position 2");
        positionRepository.saveAll(List.of(position1, position2));
    }

    public void setupPayrollComponents() {
        // Create and save payroll components
        PayrollComponent earningsComponent1 = new PayrollComponent("Basic Salary", PayrollComponentType.EARNINGS);
        PayrollComponent earningsComponent2 = new PayrollComponent("Transport Allowance", PayrollComponentType.EARNINGS);
        PayrollComponent deductionsComponent1 = new PayrollComponent("Tax Deduction", PayrollComponentType.DEDUCTIONS);
        PayrollComponent deductionsComponent2 = new PayrollComponent("Pension Deduction", PayrollComponentType.DEDUCTIONS);
        payrollComponentRepository.saveAll(List.of(earningsComponent1, earningsComponent2, deductionsComponent1, deductionsComponent2));
    }
}
