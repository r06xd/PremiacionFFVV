package com.uisrael.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "log_carga_excel")
public class LogCargaExcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDateTime fechaCarga;
    private String nombreArchivo;

    @Enumerated(EnumType.STRING)
    private EstadoCarga estado;

    @Lob
    private String errores;

    public enum EstadoCarga {
        PENDIENTE, PROCESADO, ERROR
    }

    // Getters y Setters
}