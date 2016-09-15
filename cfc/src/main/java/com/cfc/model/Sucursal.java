package com.cfc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUCURSALES database table.
 * 
 */
@JsonAutoDetect
@Entity
@Table(name = "SUCURSALES")
@NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int idSucursal;

	@Column(name = "COD_AGENCIA")
	private int codigoAgencia;

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

	//TODO Quitar @Transient y agregar las anotaciones corretas para realizar el mapeo con la BD
	@Transient
	private List<SucursalMonedaDetalle> detalleMontos;

	public Sucursal() {
		this.detalleMontos = new ArrayList<SucursalMonedaDetalle>();
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public int getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(int codigoAgencia) {
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