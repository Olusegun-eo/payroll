package com.emmanuel.payroll.service.position;

import com.emmanuel.payroll.dat.model.Position;
import com.emmanuel.payroll.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Position getPositionById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public Position updatePosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public boolean deletePosition(Long id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
