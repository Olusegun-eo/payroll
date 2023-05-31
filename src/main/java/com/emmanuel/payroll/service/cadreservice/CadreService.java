package com.emmanuel.payroll.service.cadreservice;

import com.emmanuel.payroll.dat.model.CadreLevel;

import java.util.List;

public interface CadreService {
    CadreLevel createCadreLevel(CadreLevel cadreLevel);
    CadreLevel getCadreLevelById(Long id);
    List<CadreLevel> getAllCadreLevels();

    boolean deleteCadreLevel(Long id);

    CadreLevel updateCadreLevel(CadreLevel cadreLevel);
    // Other methods for managing cadre levels

}
