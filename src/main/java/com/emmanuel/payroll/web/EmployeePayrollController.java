package com.emmanuel.payroll.web;

import com.emmanuel.payroll.dat.model.PayrollComponent;
import com.emmanuel.payroll.service.payrollsetup.EmployeePayRollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee_payroll")
public class EmployeePayrollController {
    private final EmployeePayRollService employeePayRollService;

    public EmployeePayrollController(EmployeePayRollService employeePayRollService) {
        this.employeePayRollService = employeePayRollService;
    }

    @GetMapping("/employees/{employeeId}/earnings")
    public ResponseEntity<List<PayrollComponent>> getEmployeeEarnings(@PathVariable Long employeeId) {
        List<PayrollComponent> earnings = employeePayRollService.getEmployeeEarnings(employeeId);
        return ResponseEntity.ok(earnings);
    }

    @GetMapping("/employees/{employeeId}/deductions")
    public ResponseEntity<List<PayrollComponent>> getEmployeeDeductions(@PathVariable Long employeeId) {
        List<PayrollComponent> deductions = employeePayRollService.getEmployeeDeductions(employeeId);
        return ResponseEntity.ok(deductions);
    }

}
