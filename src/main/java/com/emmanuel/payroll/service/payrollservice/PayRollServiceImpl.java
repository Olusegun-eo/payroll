package com.emmanuel.payroll.service.payrollservice;

import com.emmanuel.payroll.dat.model.Employee;
import com.emmanuel.payroll.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class PayRollServiceImpl implements PayRollService{

    private final EmployeeRepository employeeRepository;

    public PayRollServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public double calculatePayroll(Employee employee) {

        double basicSalary = employee.getSalary();
        double deductions = calculateDeductions(employee);
        double benefits = calculateBenefits(employee);

        double payRollAmount = basicSalary + benefits - deductions;
        return payRollAmount;
    }

    @Override
    public double calculateDeductions(Employee employee) {
        double taxDeduction = employee.getSalary() * 0.2; // Assuming 20% tax deduction
        double insuranceDeduction = employee.getSalary() * 0.1; // Assuming 10% insurance deduction

        double totalDeduction = taxDeduction + insuranceDeduction;
        return totalDeduction;
    }

    @Override
    public double calculateBenefits(Employee employee) {

        double allowance = employee.getPosition().getAllowance(); // Assuming position-specific allowance
        double bonus = employee.getCadreLevel().getBonus(); // Assuming cadre level-specific bonus

        double totalBenefit = allowance + bonus;
        return totalBenefit;
    }


}
