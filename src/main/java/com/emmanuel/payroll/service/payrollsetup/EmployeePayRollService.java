package com.emmanuel.payroll.service.payrollsetup;

import com.emmanuel.payroll.dat.model.Employee;
import com.emmanuel.payroll.dat.model.PayrollComponent;
import com.emmanuel.payroll.dat.model.PayrollComponentType;
import com.emmanuel.payroll.repository.EmployeeRepository;
import com.emmanuel.payroll.repository.PayrollComponentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayRollService {
    private final EmployeeRepository employeeRepository;
    private final PayrollComponentRepository payrollComponentRepository;

    public EmployeePayRollService(EmployeeRepository employeeRepository, PayrollComponentRepository payrollComponentRepository) {
        this.employeeRepository = employeeRepository;
        this.payrollComponentRepository = payrollComponentRepository;
    }

    public List<PayrollComponent> getEmployeeEarnings(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));

        return payrollComponentRepository.findByTypeAndCadreLevel(PayrollComponentType.EARNINGS, employee.getCadreLevel());
    }

    public List<PayrollComponent> getEmployeeDeductions(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));

        return payrollComponentRepository.findByTypeAndCadreLevel(PayrollComponentType.DEDUCTIONS, employee.getCadreLevel());
    }

}
