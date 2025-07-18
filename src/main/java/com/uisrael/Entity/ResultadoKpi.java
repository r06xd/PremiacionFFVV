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
    private double valorObtenido;
    private double puntosCalculados;
    private String periodo;
	public Integer getPeriodoMes() {
		return periodoMes;
	}
	public void setPeriodoMes(Integer periodoMes) {
		this.periodoMes = periodoMes;
	}
	public Integer getPeriodoAnio() {
		return periodoAnio;
	}
	public void setPeriodoAnio(Integer periodoAnio) {
		this.periodoAnio = periodoAnio;
	}
	public double getValorObtenido() {
		return valorObtenido;
	}
	public void setValorObtenido(double valorObtenido) {
		this.valorObtenido = valorObtenido;
	}
	public double getPuntosCalculados() {
		return puntosCalculados;
	}
	public void setPuntosCalculados(double puntosCalculados) {
		this.puntosCalculados = puntosCalculados;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
    
	public Kpi getKpi() {
	    return kpi;
	}

	public void setKpi(Kpi kpi) {
	    this.kpi = kpi;
	}
    
	public Usuario getUsuario() {
	    return usuario;
	}

	public void setUsuario(Usuario usuario) {
	    this.usuario = usuario;
	}

    // Getters y Setters
}