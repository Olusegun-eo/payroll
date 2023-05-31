package com.emmanuel.payroll.dat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "cadre_levels")
@NoArgsConstructor
@AllArgsConstructor
public class CadreLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cadreLevel")
    private List<Employee> employee;

    @Column(name = "bonus")
    private double bonus;

    public CadreLevel(String s) {

    }
}