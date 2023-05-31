package com.emmanuel.payroll.repository;

import com.emmanuel.payroll.dat.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeId(Long employeeId);
}
