package com.emmanuel.payroll.repository;

import com.emmanuel.payroll.dat.model.CadreLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadreLevelRepository extends JpaRepository<CadreLevel, Long>{

}