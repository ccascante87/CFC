/**
 * 
 */
package com.cfc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TRANSACCIONES database table.
 * 
 */
@Entity
@Table(name = "TRANSACCIONES")
@NamedQueries({ @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
		@NamedQuery(name = "Transaccion.findByCurrencyAndBranch", query = "SELECT t FROM Transaccion t where idSucursal = :idSucursal AND idMoneda = :idMoneda") })
public class Transaccion implements Serializable {

	private static final long serialVersionUID = -766041998091219637L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ID_MONEDA")
	private int idMoneda;

	@Column(name = "ID_SUCURSAL")
	private int idSucursal;

	@Column(name = "COD_TRANSACCION")
	private BigDecimal codTransaccion;

	@Column(name = "DESC_TRANSACCION")
	private String descTransaccion;

	@Column(name = "FECHA")
	private Date fecha;

	@Column(name = "MONTO")
	private BigDecimal monto;

	public Transaccion() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public BigDecimal getCodTransaccion() {
		return codTransaccion;
	}

	public void setCodTransaccion(BigDecimal codTransaccion) {
		this.codTransaccion = codTransaccion;
	}

	public String getDescTransaccion() {
		return descTransaccion;
	}

	public void setDescTransaccion(String descTransaccion) {
		this.descTransaccion = descTransaccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
}