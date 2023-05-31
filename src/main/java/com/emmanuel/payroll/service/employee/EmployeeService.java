package com.emmanuel.payroll.service.employee;

import com.emmanuel.payroll.dat.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
}
