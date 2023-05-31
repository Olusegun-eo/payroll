package com.emmanuel.payroll.repository;

import com.emmanuel.payroll.dat.model.CadreLevel;
import com.emmanuel.payroll.dat.model.PayrollComponent;
import com.emmanuel.payroll.dat.model.PayrollComponentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollComponentRepository extends JpaRepository<PayrollComponent, Long> {
    List<PayrollComponent> findByTypeAndCadreLevel(PayrollComponentType earnings, CadreLevel cadreLevel);
}
