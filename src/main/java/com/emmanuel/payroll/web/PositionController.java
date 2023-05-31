package com.emmanuel.payroll.web;


import com.emmanuel.payroll.dat.model.Position;
import com.emmanuel.payroll.service.position.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positon")
public class PositionController {

        private final PositionService positionService;

        public PositionController(PositionService positionService) {
            this.positionService = positionService;
        }

        @GetMapping
        public ResponseEntity<List<Position>> getAllPositions() {
            List<Position> positions = positionService.getAllPositions();
            return ResponseEntity.ok(positions);
        }

        @PostMapping
        public ResponseEntity<Position> createPosition(@RequestBody Position position) {
            Position createdPosition = positionService.createPosition(position);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPosition);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Position> getPositionById(@PathVariable Long id) {
            Position position = positionService.getPositionById(id);
            if (position == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(position);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Position> updatePosition(@PathVariable Long id, @RequestBody Position updatedPosition) {
            Position position = positionService.getPositionById(id);
            if (position == null) {
                return ResponseEntity.notFound().build();
            }
            position.setName(updatedPosition.getName());
            position.setAllowance(updatedPosition.getAllowance());
            Position updated = positionService.updatePosition(position);
            return ResponseEntity.ok(updated);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePosition(@PathVariable Long id) {
            boolean deleted = positionService.deletePosition(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
}
