package com.emmanuel.payroll.dat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payroll_components")
public class PayrollComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PayrollComponentType type;

    @ManyToOne
    @JoinColumn(name = "cadre_level_id")
    private CadreLevel cadreLevel;

    public PayrollComponent(String basic_salary, PayrollComponentType earnings) {

    }
}
