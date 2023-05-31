package com.emmanuel.payroll.service.cadreservice;

import com.emmanuel.payroll.dat.model.CadreLevel;
import com.emmanuel.payroll.repository.CadreLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadreServiceImpl implements CadreService{

    private final CadreLevelRepository cadreLevelRepository;

    public CadreServiceImpl(CadreLevelRepository cadreLevelRepository) {
        this.cadreLevelRepository = cadreLevelRepository;
    }

    @Override
    public CadreLevel createCadreLevel(CadreLevel cadreLevel) {
        // Implement the logic for creating a cadre level
        return cadreLevelRepository.save(cadreLevel);
    }

    @Override
    public List<CadreLevel> getAllCadreLevels() {
        // Implement the logic for retrieving all cadre levels
        return cadreLevelRepository.findAll();
    }

    // Implement other methods for managing cadre levels

    @Override
    public CadreLevel getCadreLevelById(Long id) {
        return cadreLevelRepository.findById(id).orElse(null);
    }

    @Override
    public CadreLevel updateCadreLevel(CadreLevel cadreLevel) {
        return cadreLevelRepository.save(cadreLevel);
    }

    @Override
    public boolean deleteCadreLevel(Long id) {
        if (cadreLevelRepository.existsById(id)) {
            cadreLevelRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
