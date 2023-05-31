package com.emmanuel.payroll.service.payrollservice;

import com.emmanuel.payroll.dat.model.Employee;

public interface PayRollService {
    double calculatePayroll(Employee employee);

    double calculateBenefits(Employee employee);
    double calculateDeductions(Employee employee);

}
