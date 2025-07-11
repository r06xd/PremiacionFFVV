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
@Table(name = "resultado_kpi")
public class ResultadoKpi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "kpi_id")
    private Kpi kpi;

    private Integer periodoMes;
    private Integer periodoAnio;
    private BigDecimal valorObtenido;
    private BigDecimal puntosCalculados;
    private String periodo;
    
    //revisar creados automaticamente
	public void setperiodoMes(int numericCellValue) {
		// TODO Auto-generated method stub
		
	}
	public void setperiodoAnio(int numericCellValue) {
		// TODO Auto-generated method stub
		
	}
	public void setusuario_id(long numericCellValue) {
		// TODO Auto-generated method stub
		
	}
	public void setKpiId(long numericCellValue) {
		// TODO Auto-generated method stub
		
	}

    // Getters y Setters
}