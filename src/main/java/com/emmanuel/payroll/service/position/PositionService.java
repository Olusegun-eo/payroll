package com.emmanuel.payroll.service.position;

import com.emmanuel.payroll.dat.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();

    Position createPosition(Position position);

    Position getPositionById(Long id);

    Position updatePosition(Position position);

    boolean deletePosition(Long id);
}
