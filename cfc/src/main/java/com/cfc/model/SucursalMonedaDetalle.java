package com.cfc.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SucursalMonedaDetalle implements Serializable {

	private static final long serialVersionUID = -3741953317807098803L;
	private Sucursal sucursal;
	private Moneda moneda;
	private BigDecimal montoAsegurado;
	private BigDecimal montoAutorizado;

	public SucursalMonedaDetalle() {
		sucursal = new Sucursal();
		moneda = new Moneda();
		montoAsegurado = BigDecimal.ZERO;
		montoAutorizado = BigDecimal.ZERO;
	}

	public Sucursal getSucursal() {
		return sucursal;
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

	public BigDecimal getMontoAsegurado() {
		return montoAsegurado;
	}

	public void setMontoAsegurado(BigDecimal montoAsegurado) {
		this.montoAsegurado = montoAsegurado;
	}

	public BigDecimal getMontoAutorizado() {
		return montoAutorizado;
	}

	public void setMontoAutorizado(BigDecimal montoAutorizado) {
		this.montoAutorizado = montoAutorizado;
	}

}
