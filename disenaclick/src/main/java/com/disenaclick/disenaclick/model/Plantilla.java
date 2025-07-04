package com.disenaclick.disenaclick.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plantilla")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Plantilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String nombrePlantilla;

    @Column(length = 15, nullable = false)
    private String color;

    @Column(length = 100, nullable = false)
    private String enlace;

}
