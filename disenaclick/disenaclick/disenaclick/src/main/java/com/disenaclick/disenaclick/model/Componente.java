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
@Table(name = "componente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Componente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String textoComponente;

    /*
     * @Column(nullable = false)
     * private String botonComponente; se investigara y añadira posiblemente en el
     * futuro
     */

    /*
     * @Column(nullable = false)
     * private String urlImgComponente; se investigara y añadira posiblemente en el
     * futuro
     */

}
