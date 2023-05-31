package com.emmanuel.payroll.web;

import com.emmanuel.payroll.dat.model.Employee;
import com.emmanuel.payroll.repository.EmployeeRepository;
import com.emmanuel.payroll.service.payrollservice.PayRollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payroll")
public class PayRollController {

    private final PayRollService payRollService;
    private final EmployeeRepository employeeRepository;

    public PayRollController(PayRollService payRollService, EmployeeRepository employeeRepository) {
        this.payRollService = payRollService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/calculate/{employeeId}")
    public ResponseEntity<Double> calculatePayroll(@PathVariable Long employeeId) {
        // Retrieve the employee from the database using the employeeId
        Employee employee = employeeRepository.findByEmployeeId(employeeId);// Implement logic to fetch employee from the database using the employeeId
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        // Pass the employee to the payrollService to calculate the payroll
        double payroll = payRollService.calculatePayroll(employee);
        // Return the calculated payroll amount in the response
        return ResponseEntity.ok(payroll);
    }


    @GetMapping("/deductions/{employeeId}")
    public ResponseEntity<Double> calculateDeductions(@PathVariable Long employeeId) {
        // Retrieve the employee from the database using the employeeId
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        // Calculate deductions for the employee
        double deductions = payRollService.calculateDeductions(employee);

        // Return the calculated deductions amount in the response
        return ResponseEntity.ok(deductions);
    }

    @GetMapping("/benefits/{employeeId}")
    public ResponseEntity<Double> calculateBenefits(@PathVariable Long employeeId) {
        // Retrieve the employee from the database using the employeeId
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        // Calculate benefits for the employee
        double benefits = payRollService.calculateBenefits(employee);

        // Return the calculated benefits amount in the response
        return ResponseEntity.ok(benefits);
    }

}
