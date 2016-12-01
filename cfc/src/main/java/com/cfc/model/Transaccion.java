package com.cfc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the TRANSACCIONES database table.
 * 
 */
@Entity
@Table(name="TRANSACCIONES")
@NamedQuery(name="Transacciones.findAll", query="SELECT t FROM Transaccion t")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="COD_TRANSACCION")
	private BigDecimal codTransaccion;

	@Column(name="DESC_TRANSACCION")
	private String descTransaccion;

	private Timestamp fecha;

	@Column(name="ID_MONEDA")
	private BigDecimal idMoneda;

	@Column(name="ID_SUCURSAL")
	private BigDecimal idSucursal;

	private BigDecimal monto;

	public Transaccion() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCodTransaccion() {
		return this.codTransaccion;
	}

	public void setCodTransaccion(BigDecimal codTransaccion) {
		this.codTransaccion = codTransaccion;
	}

	public String getDescTransaccion() {
		return this.descTransaccion;
	}

	public void setDescTransaccion(String descTransaccion) {
		this.descTransaccion = descTransaccion;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIdMoneda() {
		return this.idMoneda;
	}

	public void setIdMoneda(BigDecimal idMoneda) {
		this.idMoneda = idMoneda;
	}

	public BigDecimal getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(BigDecimal idSucursal) {
		this.idSucursal = idSucursal;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

}