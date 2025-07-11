package com.uisrael.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ranking_mensual")
public class RankingMensual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private Integer periodoMes;
    private Integer periodoAnio;
    private BigDecimal puntosTotales;
    private Integer posicion;
    private Boolean acelerador1Aplicado;
    private Boolean acelerador2Aplicado;
    private String periodo;

    // Getters y Setters
}