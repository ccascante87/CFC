package com.cfc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the SUCURSALES database table.
 * 
 */
@Entity
@Table(name="SUCURSALES")
@NamedQuery(name="Sucursal.findAll", query="SELECT s FROM Sucursal s")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SUCURSAL")
	private long idSucursal;

	@Column(name="CODIGO_AGENCIA")
	private BigDecimal codigoAgencia;

	@Column(name="HORA_APERTURA")
	private Timestamp horaApertura;

	@Column(name="HORA_CIERRE")
	private Timestamp horaCierre;

	@Column(name="MONTO_ASEGURADO")
	private BigDecimal montoAsegurado;

	@Column(name="MONTO_AUTORIZADO")
	private BigDecimal montoAutorizado;

	@Column(name="NOM_AGENCIA")
	private String nomAgencia;

	public Sucursal() {
	}

	public long getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}

	public BigDecimal getCodigoAgencia() {
		return this.codigoAgencia;
	}

	public void setCodigoAgencia(BigDecimal codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public Timestamp getHoraApertura() {
		return this.horaApertura;
	}

	public void setHoraApertura(Timestamp horaApertura) {
		this.horaApertura = horaApertura;
	}

	public Timestamp getHoraCierre() {
		return this.horaCierre;
	}

	public void setHoraCierre(Timestamp horaCierre) {
		this.horaCierre = horaCierre;
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

	public String getNomAgencia() {
		return this.nomAgencia;
	}

	public void setNomAgencia(String nomAgencia) {
		this.nomAgencia = nomAgencia;
	}

}