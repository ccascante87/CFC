package com.cfc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the SALDOS database table.
 * 
 */
@Entity
@Table(name="SALDOS")
@NamedQuery(name="Saldo.findAll", query="SELECT s FROM Saldo s")
public class Saldo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SALDO")
	private long idSaldo;

	@Column(name="CODIGO_AGENCIA")
	private BigDecimal codigoAgencia;

	@Column(name="CODIGO_MONEDA")
	private BigDecimal codigoMoneda;

	@Column(name="CODIGO_USUARIO")
	private String codigoUsuario;

	private Timestamp fecha;

	private BigDecimal id;

	private BigDecimal monto;

	@Column(name="NOM_AGENCIA")
	private String nomAgencia;

	@Column(name="NOM_USUARIO")
	private String nomUsuario;

	public Saldo() {
	}

	public long getIdSaldo() {
		return this.idSaldo;
	}

	public void setIdSaldo(long idSaldo) {
		this.idSaldo = idSaldo;
	}

	public BigDecimal getCodigoAgencia() {
		return this.codigoAgencia;
	}

	public void setCodigoAgencia(BigDecimal codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public BigDecimal getCodigoMoneda() {
		return this.codigoMoneda;
	}

	public void setCodigoMoneda(BigDecimal codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public String getCodigoUsuario() {
		return this.codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getNomAgencia() {
		return this.nomAgencia;
	}

	public void setNomAgencia(String nomAgencia) {
		this.nomAgencia = nomAgencia;
	}

	public String getNomUsuario() {
		return this.nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

}