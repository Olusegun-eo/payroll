package com.emmanuel.payroll.service.employee;


import com.emmanuel.payroll.dat.model.Employee;
import com.emmanuel.payroll.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        // Implement the logic for creating an employee
        // You can perform any necessary validations or calculations here
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        // Implement the logic for retrieving an employee by ID
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        // Implement the logic for retrieving all employees
        return employeeRepository.findAll();
    }
}
