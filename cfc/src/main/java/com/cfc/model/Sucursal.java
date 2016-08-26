package com.cfc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the SUCURSALES database table.
 * 
 */
@Entity
@Table(name = "SUCURSALES")
@NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long idSucursal;

	@Column(name = "COD_AGENCIA")
	private BigDecimal codigoAgencia;
	
	@Column(name = "NOM_AGENCIA")
	private String nomAgencia;

	@Column(name = "HORA_APERTURA")
	private String horaApertura;

	@Column(name = "HORA_CIERRE")
	private String horaCierre;

	@Column(name = "MONTO_ASEGURADO")
	private BigDecimal montoAsegurado;

	@Column(name = "MONTO_AUTORIZADO")
	private BigDecimal montoAutorizado;

	public Sucursal() {
	}

	public long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}

	public BigDecimal getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(BigDecimal codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public String getNomAgencia() {
		return nomAgencia;
	}

	public void setNomAgencia(String nomAgencia) {
		this.nomAgencia = nomAgencia;
	}

	public String getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(String horaApertura) {
		this.horaApertura = horaApertura;
	}

	public String getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
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