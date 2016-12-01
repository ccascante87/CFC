package com.cfc.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the SUCURSAL_MONTO_MONEDA database table.
 * 
 */
@Entity
@Table(name = "SUCURSAL_MONTO_MONEDA")
@NamedQuery(name = "SucursalMontoMoneda.findAll", query = "SELECT s FROM SucursalMontoMoneda s")
public class SucursalMontoMoneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal id;

	@Column(name = "MONTO_ASEGURADO")
	private BigDecimal montoAsegurado;

	@Column(name = "MONTO_AUTORIZADO")
	private BigDecimal montoAutorizado;

	// bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name = "ID_SUCURSAL")
	private Sucursal sucursal;

	@ManyToOne
	@JoinColumn(name = "ID_MONEDA")
	private Moneda moneda;

	public SucursalMontoMoneda() {
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getMontoAsegurado() {
		return this.montoAsegurado;
	}

	public void setMontoAsegurado(BigDecimal montoAsegurado) {
		this.montoAsegurado = montoAsegurado;
	}

	public BigDecimal getMontoAutorizado() {
		return this.montoAutorizado;
	}

	public void setMontoAutorizado(BigDecimal montoAutorizado) {
		this.montoAutorizado = montoAutorizado;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getId() {
		return id;
	}
}