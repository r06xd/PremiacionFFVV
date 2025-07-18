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
    private double puntosTotales;
    private Integer posicion;
    private Boolean acelerador1Aplicado;
    private Boolean acelerador2Aplicado;
    private String periodo;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
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
	public double getPuntosTotales() {
		return puntosTotales;
	}
	public void setPuntosTotales(double puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	public Integer getPosicion() {
		return posicion;
	}
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	public Boolean getAcelerador1Aplicado() {
		return acelerador1Aplicado;
	}
	public void setAcelerador1Aplicado(Boolean acelerador1Aplicado) {
		this.acelerador1Aplicado = acelerador1Aplicado;
	}
	public Boolean getAcelerador2Aplicado() {
		return acelerador2Aplicado;
	}
	public void setAcelerador2Aplicado(Boolean acelerador2Aplicado) {
		this.acelerador2Aplicado = acelerador2Aplicado;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

    // Getters y Setters
}